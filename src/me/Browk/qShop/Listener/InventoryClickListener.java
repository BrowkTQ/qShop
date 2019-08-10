package me.Browk.qShop.Listener;

import me.Browk.qShop.Shop.ShopItem;
import me.Browk.qShop.Shop.ShopUtils;
import me.Browk.qShop.Utils;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryClickListener implements Listener, Utils {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();
        if (!inventory.getName().equalsIgnoreCase("§8Magazin Zilnic") && !inventory.getName().equalsIgnoreCase("§8Magazin Zilnic | Item")) {
            return;
        }
        event.setCancelled(true);
        if (event.getCurrentItem() == null) {
            return;
        }
        HumanEntity p = event.getWhoClicked();
        if (inventory.getName().equalsIgnoreCase("§8Magazin Zilnic")) {
            ShopItem shopItem = ShopUtils.getShopItem(event.getSlot());
            if (shopItem == null) {
                return;
            }
            p.closeInventory();
            ShopUtils.openBuySell(p, shopItem);
        } else if (inventory.getName().equalsIgnoreCase("§8Magazin Zilnic | Item")) {
            ItemStack item = event.getCurrentItem();
            if (item.getType().equals(Material.STAINED_GLASS_PANE)) {
                if (item.getDurability() == 5) {
                    ItemMeta itemMeta = item.getItemMeta();
                    ItemStack shopItem = inventory.getItem(13);
                    if (itemMeta.getDisplayName().equalsIgnoreCase("§a§l+64")) {
                        shopItem.setAmount(64);
                        return;
                    }
                    if (itemMeta.getDisplayName().equalsIgnoreCase("§a§l+32")) {
                        if (shopItem.getAmount() >= 32) {
                            shopItem.setAmount(64);
                            return;
                        }
                        shopItem.setAmount(shopItem.getAmount() + 32);
                        return;
                    }
                    if (itemMeta.getDisplayName().equalsIgnoreCase("§a§l+1")) {
                        if (shopItem.getAmount() >= 63) {
                            shopItem.setAmount(64);
                            return;
                        }
                        shopItem.setAmount(shopItem.getAmount() + 1);
                        return;
                    }
                }
                if (item.getDurability() == 14) {
                    ItemMeta itemMeta = item.getItemMeta();
                    ItemStack shopItem = inventory.getItem(13);
                    if (itemMeta.getDisplayName().equalsIgnoreCase("§c§l-64")) {
                        shopItem.setAmount(1);
                        return;
                    }
                    if (itemMeta.getDisplayName().equalsIgnoreCase("§c§l-32")) {
                        if (shopItem.getAmount() <= 33) {
                            shopItem.setAmount(1);
                            return;
                        }
                        shopItem.setAmount(shopItem.getAmount() - 32);
                        return;
                    }
                    if (itemMeta.getDisplayName().equalsIgnoreCase("§c§l-1")) {
                        if (shopItem.getAmount() <= 2) {
                            shopItem.setAmount(1);
                            return;
                        }
                        shopItem.setAmount(shopItem.getAmount() - 1);
                    }
                }
            } else if (item.getType().equals(Material.WOOL)) {
                ItemMeta itemMeta = item.getItemMeta();
                ItemStack itemStack = inventory.getItem(13);
                if (itemMeta.getDisplayName().equalsIgnoreCase("§c§lVinde tot")) {
                    p.closeInventory();
                    ShopItem shopItem = ShopUtils.getShopItem(itemStack);
                    int amount = takeAllItems(p.getInventory(), shopItem.getMaterial(), shopItem.getMaterialData());
                    if (amount > 0) {
                        double price = round(amount * shopItem.getSellPrice(), 2);
                        giveMoney((Player) p, price);
                        p.sendMessage("§6► §fAi vandut §e" + amount + "§8 x §e" + shopItem.getName() + "§f pentru §a$" + price + "§f.");
                    } else {
                        p.sendMessage("§6► §cNu ai niciun obiect de acest tip.");
                    }
                } else if (itemMeta.getDisplayName().equalsIgnoreCase("§c§lVinde")) {
                    p.closeInventory();
                    ShopItem shopItem = ShopUtils.getShopItem(itemStack);
                    int amount = takeItems(p.getInventory(), itemStack);
                    if (amount != 0) {
                        double price = round(amount * shopItem.getSellPrice(), 2);
                        giveMoney((Player) p, price);
                        p.sendMessage("§6► §fAi vandut §e" + amount + "§8 x §e" + shopItem.getName() + "§f pentru §a$" + price + "§f.");
                    } else {
                        p.sendMessage("§6► §cNu ai suficiente obiecte de acest tip.");
                    }
                } else if (itemMeta.getDisplayName().equalsIgnoreCase("§a§lCumpara")) {
                    p.closeInventory();
                    ShopItem shopItem = ShopUtils.getShopItem(itemStack);
                    PlayerInventory pInventory = p.getInventory();
                    int amount = itemStack.getAmount();
                    double price = round(amount * shopItem.getBuyPrice(), 2);
                    if (!hasMoney((Player) p, price)) {
                        p.sendMessage("§6► §cNu ai suficienti bani pentru a cumpara acest obiect.");
                        return;
                    }
                    if (getFreeSpace(pInventory, shopItem.getMaterial(), shopItem.getMaterialData()) >= amount) {
                        if (!takeMoney((Player) p, price)) {
                            p.sendMessage("§6► §cA avut loc o eroare in timpul efectuarii tranzactiei.");
                        }
                        giveItems(pInventory, itemStack);
                        p.sendMessage("§6► §fAi cumparat §e" + amount + "§8 x §e" + shopItem.getName() + "§f pentru §c$" + price + "§f.");
                    } else {
                        p.sendMessage("§6► §cNu ai suficient spatiu in inventar.");
                    }
                } else if (itemMeta.getDisplayName().equalsIgnoreCase("§a§lCumpara tot")) {
                    p.closeInventory();
                    ShopItem shopItem = ShopUtils.getShopItem(itemStack);
                    PlayerInventory pInventory = p.getInventory();
                    int amount = getFreeSpace(pInventory, shopItem.getMaterial(), shopItem.getMaterialData());
                    if (amount == 0) {
                        p.sendMessage("§6► §cNu ai suficient spatiu in inventar.");
                        return;
                    }
                    double money = getMoney((Player) p);
                    if (money < amount * shopItem.getBuyPrice()) {
                        amount = (int) (money/shopItem.getBuyPrice());
                    }
                    if (amount == 0) {
                        p.sendMessage("§6► §cNu ai suficienti bani.");
                        return;
                    }
                    double price = round(amount * shopItem.getBuyPrice(), 2);
                    if (getFreeSpace(pInventory, shopItem.getMaterial(), shopItem.getMaterialData()) >= amount) {
                        if (!takeMoney((Player) p, price)) {
                            p.sendMessage("§6► §cA avut loc o eroare in timpul efectuarii tranzactiei.");
                        }
                        giveItems(pInventory, itemStack, amount);
                        p.sendMessage("§6► §fAi cumparat §e" + amount + "§8 x §e" + shopItem.getName() + "§f pentru §c$" + price + "§f.");
                    } else {
                        p.sendMessage("§6► §cNu ai suficient spatiu in inventar.");
                    }
                }
            } else if (item.getType().equals(Material.BARRIER)) {
                p.closeInventory();
                ShopUtils.openShop((Player) p);
            }
        }

    }

}
