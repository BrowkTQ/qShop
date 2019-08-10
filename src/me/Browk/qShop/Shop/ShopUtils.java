package me.Browk.qShop.Shop;

import com.google.common.collect.Lists;
import me.Browk.qShop.Handlers.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;

public class ShopUtils {

    private static HashMap<Integer, ShopItem> shopItems;
    public static Inventory shopInventory;
    public static Inventory shopBuySellInventory;

    public static void generateShop() {
        shopItems = new HashMap<Integer, ShopItem>();
        ConfigHandler setting = ConfigHandler.getInstance();
        int[] numbers = { 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 29, 30, 31, 32, 33 };
        int i = 0;
        for(ShopItem shopItem : setting.loadShop()) {
            shopItems.put(numbers[i], shopItem);
            i++;
        }
        generateShopMenu();
        generateShopBuySellMenu();
    }

    public static void generateShopMenu() {
        shopInventory = Bukkit.createInventory(null, 45, "§8Magazin Zilnic");
        int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 26, 27, 28, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44 };
        ItemStack glass = getMenuGlass();
        for(Integer pos : numbers) {
            shopInventory.setItem(pos, glass);
        }
        for(Integer pos : shopItems.keySet()) {
            shopInventory.setItem(pos, getMenuItem(pos));
        }
    }

    public static ItemStack getMenuItem(Integer i) {
        ShopItem shopItem = shopItems.get(i);
        ItemStack item = new ItemStack(shopItem.getMaterial(), 1, shopItem.getMaterialData());
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§e§l" + shopItem.getName());
        itemMeta.setLore(Lists.newArrayList("§6► §fCumpara cu §c$" + shopItem.getBuyPrice() + "§f.", "§6► §fVinde cu §a$" + shopItem.getSellPrice() + "§f."));
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getMenuBuySellItem(ShopItem shopItem, Integer amount) {
        ItemStack item = new ItemStack(shopItem.getMaterial(), amount, shopItem.getMaterialData());
        return item;
    }

    public static ItemStack getMenuGlass() {
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 0);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§f ");
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack getMenuGlass(String name, byte x) {
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, x);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ShopItem getShopItem(Integer pos) {
        if (!shopItems.containsKey(pos)) {
            return null;
        }
        return shopItems.get(pos);
    }

    public static void openBuySell(HumanEntity p, ShopItem shopItem) {
        Inventory tempInventory = shopBuySellInventory;
        tempInventory.setItem(13, getMenuBuySellItem(shopItem, 1));
        p.openInventory(tempInventory);
    }

    public static void generateShopBuySellMenu() {
        shopBuySellInventory = Bukkit.createInventory(null, 45, "§8Magazin Zilnic | Item");
        shopBuySellInventory.setItem(10, getMenuGlass("§a§l+64", (byte) 5));
        shopBuySellInventory.setItem(11, getMenuGlass("§a§l+32", (byte) 5));
        shopBuySellInventory.setItem(12, getMenuGlass("§a§l+1", (byte) 5));
        shopBuySellInventory.setItem(14, getMenuGlass("§c§l-1", (byte) 14));
        shopBuySellInventory.setItem(15, getMenuGlass("§c§l-32", (byte) 14));
        shopBuySellInventory.setItem(16, getMenuGlass("§c§l-64", (byte) 14));
        ItemStack redWool = new ItemStack(Material.WOOL, 1, (byte) 14);
        ItemMeta redWoolItemMeta = redWool.getItemMeta();
        redWoolItemMeta.setDisplayName("§c§lVinde tot");
        redWoolItemMeta.setLore(Arrays.asList("§6► §fVinde toate produsele de acest", "§f tip pe care le ai in inventar."));
        redWool.setItemMeta(redWoolItemMeta);
        shopBuySellInventory.setItem(33, redWool);
        redWoolItemMeta.setDisplayName("§c§lVinde");
        redWoolItemMeta.setLore(Arrays.asList("§6► §fVinde produsul selectat."));
        redWool.setItemMeta(redWoolItemMeta);
        shopBuySellInventory.setItem(32, redWool);
        ItemStack greenWool = new ItemStack(Material.WOOL, 1, (byte) 5);
        ItemMeta greenWoolItemMeta = greenWool.getItemMeta();
        greenWoolItemMeta.setDisplayName("§a§lCumpara tot");
        greenWoolItemMeta.setLore(Arrays.asList("§6► §fCumpara produsul selectat", "§f de toti banii pe care ii ai."));
        greenWool.setItemMeta(greenWoolItemMeta);
        shopBuySellInventory.setItem(29, greenWool);
        greenWoolItemMeta.setDisplayName("§a§lCumpara");
        greenWoolItemMeta.setLore(Arrays.asList("§6► §fCumpara produsul selectat."));
        greenWool.setItemMeta(greenWoolItemMeta);
        shopBuySellInventory.setItem(30, greenWool);
        ItemStack barrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta barrierMeta = barrier.getItemMeta();
        barrierMeta.setDisplayName("§c§lInapoi");
        barrier.setItemMeta(barrierMeta);
        shopBuySellInventory.setItem(31, barrier);
        int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44 };
        for (int i : numbers) {
            shopBuySellInventory.setItem(i, getMenuGlass());
        }
    }

    public static ShopItem getShopItem(ItemStack item) {
        Material material = item.getType();
        byte materialData = (byte) item.getDurability();
        for (ShopItem shopItem : shopItems.values()) {
            if (shopItem.getMaterial() == material && shopItem.getMaterialData() == materialData) {
                return shopItem;
            }
        }
        return null;
    }

    public static void openShop(Player player) {
        player.openInventory(shopInventory);
    }

}
