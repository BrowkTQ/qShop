package me.Browk.qShop;

import me.Browk.qShop.Shop.ShopUtils;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Utils {

    default Main getInstance() {
        return Main.instance;
    }

    default double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    default String replace(String s) {
        return s.replace("&", "§");
    }

    default void sendLogger(final String mesaj) {
        this.getInstance().getServer().getConsoleSender().sendMessage(replace(mesaj));
    }

    default void noConsole(final CommandSender sender) {
        sendLogger("&6► &cTrebuie sa fii &4jucator &cpentru a face asta!");
    }

    default Economy getEconomy() {
        return Main.econ;
    }

    default boolean takeMoney(Player p, double x) {
        EconomyResponse r = getEconomy().withdrawPlayer(p, x);
        return r.transactionSuccess();
    }

    default boolean hasMoney(Player p, double x) {
        return getEconomy().getBalance(p) >= x;
    }

    default double getMoney(Player p) {
        return getEconomy().getBalance(p);
    }

    default boolean giveMoney(Player p, double x) {
        EconomyResponse r = getEconomy().depositPlayer(p, x);
        return r.transactionSuccess();
    }

    default Integer takeAllItems(PlayerInventory inventory, Material m, byte mData) {
        int amount = 0;
        for(ItemStack itemStack : inventory.getContents()) {
            if ((itemStack != null) && (itemStack.getType() == m) && (itemStack.getDurability() == mData)) {
                inventory.remove(itemStack);
                amount += itemStack.getAmount();
            }
        }
        return amount;
    }

    default Integer takeItems(PlayerInventory inventory, ItemStack item) {
        int amount = item.getAmount();
        Material m = item.getType();
        byte mData = (byte) item.getDurability();
        if(!itemCount(inventory, m, mData, amount)) {
            return 0;
        }
        for(ItemStack itemStack : inventory.getContents()) {
            if ((itemStack != null) && (itemStack.getType() == m) && (itemStack.getDurability() == mData)) {
                if (amount >= itemStack.getAmount()) {
                    amount -= itemStack.getAmount();
                    inventory.remove(itemStack);
                } else {
                    itemStack.setAmount(itemStack.getAmount() - amount);
                    amount = 0;
                }
                if(amount == 0) {
                    return item.getAmount();
                }
            }
        }
        return item.getAmount();
    }

    default boolean itemCount(PlayerInventory inventory, Material m, byte mData, int amount) {
        for (ItemStack itemStack : inventory.getContents()) {
            if ((itemStack != null) && (itemStack.getType() == m) && (itemStack.getDurability() == mData)) {
                amount -= itemStack.getAmount();
            }
            if (amount <= 0) {
                return true;
            }
        }
        return false;
    }

    default boolean giveItems(PlayerInventory inventory, ItemStack item) {
        inventory.addItem(item);
        return false;
    }

    default void giveItems(PlayerInventory inventory, ItemStack item, Integer amount) {
        while (amount != 0) {
            if (amount >= item.getMaxStackSize()) {
                inventory.addItem(item);
                amount -= item.getAmount();
            } else {
                item.setAmount(amount);
                inventory.addItem(item);
                amount = 0;
            }
        }
    }

    default Integer getFreeSpace(PlayerInventory inventory, Material m, byte mData) {
        int amount = 0;
        for (ItemStack itemStack : inventory.getContents()) {
            if (itemStack == null) {
                if (!(m == Material.ENDER_PEARL) && !(m == Material.EGG)) {
                    amount += 64;
                } else {
                    amount += 16;
                }
                continue;
            }
            if ((itemStack.getType() == m) && (itemStack.getDurability() == mData)) {
                amount += itemStack.getMaxStackSize() - itemStack.getAmount();
            }
        }
        return amount;
    }

}
