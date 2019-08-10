package me.Browk.qShop.Handlers;

import me.Browk.qShop.Shop.ShopItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ConfigHandler {

    static ConfigHandler instance = new ConfigHandler();
    FileConfiguration config;
    File cfile;

    public static ConfigHandler getInstance() {
        return instance;
    }

    public void setup(Plugin p) {
        config = p.getConfig();
        cfile = new File(p.getDataFolder(), "shopitems.yml");
        config.options().header("qShop by Browk_.\n");

        config.addDefault("Farm.1.item", "CARROT_ITEM");
        config.addDefault("Farm.1.data", 0);
        config.addDefault("Farm.1.name", "Carrot");
        config.addDefault("Farm.1.lowest-buy-price", 2.81);
        config.addDefault("Farm.1.highest-buy-price", 3.90);
        config.addDefault("Farm.1.lowest-sell-price", 1.21);
        config.addDefault("Farm.1.highest-sell-price", 2.30);
        config.addDefault("Farm.2.item", "POTATO_ITEM");
        config.addDefault("Farm.2.data", 0);
        config.addDefault("Farm.2.name", "Potato");
        config.addDefault("Farm.2.lowest-buy-price", 2.81);
        config.addDefault("Farm.2.highest-buy-price", 3.90);
        config.addDefault("Farm.2.lowest-sell-price", 1.21);
        config.addDefault("Farm.2.highest-sell-price", 2.30);
        config.addDefault("Farm.3.item", "CACTUS");
        config.addDefault("Farm.3.data", 0);
        config.addDefault("Farm.3.name", "Cactus");
        config.addDefault("Farm.3.lowest-buy-price", 2.81);
        config.addDefault("Farm.3.highest-buy-price", 3.90);
        config.addDefault("Farm.3.lowest-sell-price", 1.21);
        config.addDefault("Farm.3.highest-sell-price", 2.30);
        config.addDefault("Farm.4.item", "WHEAT");
        config.addDefault("Farm.4.data", 0);
        config.addDefault("Farm.4.name", "Wheat");
        config.addDefault("Farm.4.lowest-buy-price", 2.81);
        config.addDefault("Farm.4.highest-buy-price", 3.90);
        config.addDefault("Farm.4.lowest-sell-price", 1.21);
        config.addDefault("Farm.4.highest-sell-price", 2.30);
        config.addDefault("Farm.5.item", "SEEDS");
        config.addDefault("Farm.5.data", 0);
        config.addDefault("Farm.5.name", "Seeds");
        config.addDefault("Farm.5.lowest-buy-price", 2.81);
        config.addDefault("Farm.5.highest-buy-price", 3.90);
        config.addDefault("Farm.5.lowest-sell-price", 1.21);
        config.addDefault("Farm.5.highest-sell-price", 2.30);
        config.addDefault("Farm.6.item", "MELON");
        config.addDefault("Farm.6.data", 0);
        config.addDefault("Farm.6.name", "Melon");
        config.addDefault("Farm.6.lowest-buy-price", 2.81);
        config.addDefault("Farm.6.highest-buy-price", 3.90);
        config.addDefault("Farm.6.lowest-sell-price", 1.21);
        config.addDefault("Farm.6.highest-sell-price", 2.30);
        config.addDefault("Farm.7.item", "SUGAR_CANE");
        config.addDefault("Farm.7.data", 0);
        config.addDefault("Farm.7.name", "Sugar Cane");
        config.addDefault("Farm.7.lowest-buy-price", 2.81);
        config.addDefault("Farm.7.highest-buy-price", 3.90);
        config.addDefault("Farm.7.lowest-sell-price", 1.21);
        config.addDefault("Farm.7.highest-sell-price", 2.30);
        config.addDefault("Farm.8.item", "PUMPKIN");
        config.addDefault("Farm.8.data", 0);
        config.addDefault("Farm.8.name", "Pumpkin");
        config.addDefault("Farm.8.lowest-buy-price", 2.81);
        config.addDefault("Farm.8.highest-buy-price", 3.90);
        config.addDefault("Farm.8.lowest-sell-price", 1.21);
        config.addDefault("Farm.8.highest-sell-price", 2.30);
        config.addDefault("Mobs.1.item", "ROTTEN_FLESH");
        config.addDefault("Mobs.1.data", 0);
        config.addDefault("Mobs.1.name", "Rotten Flesh");
        config.addDefault("Mobs.1.lowest-buy-price", 2.81);
        config.addDefault("Mobs.1.highest-buy-price", 3.90);
        config.addDefault("Mobs.1.lowest-sell-price", 1.21);
        config.addDefault("Mobs.1.highest-sell-price", 2.30);
        config.addDefault("Mobs.2.item", "SULPHUR");
        config.addDefault("Mobs.2.data", 0);
        config.addDefault("Mobs.2.name", "Gunpowder");
        config.addDefault("Mobs.2.lowest-buy-price", 2.81);
        config.addDefault("Mobs.2.highest-buy-price", 3.90);
        config.addDefault("Mobs.2.lowest-sell-price", 1.21);
        config.addDefault("Mobs.2.highest-sell-price", 2.30);
        config.addDefault("Mobs.3.item", "BONE");
        config.addDefault("Mobs.3.data", 0);
        config.addDefault("Mobs.3.name", "Bone");
        config.addDefault("Mobs.3.lowest-buy-price", 2.81);
        config.addDefault("Mobs.3.highest-buy-price", 3.90);
        config.addDefault("Mobs.3.lowest-sell-price", 1.21);
        config.addDefault("Mobs.3.highest-sell-price", 2.30);
        config.addDefault("Mobs.4.item", "STRING");
        config.addDefault("Mobs.4.data", 0);
        config.addDefault("Mobs.4.name", "String");
        config.addDefault("Mobs.4.lowest-buy-price", 2.81);
        config.addDefault("Mobs.4.highest-buy-price", 3.90);
        config.addDefault("Mobs.4.lowest-sell-price", 1.21);
        config.addDefault("Mobs.4.highest-sell-price", 2.30);
        config.addDefault("Mobs.5.item", "SPIDER_EYE");
        config.addDefault("Mobs.5.data", 0);
        config.addDefault("Mobs.5.name", "Spider Eye");
        config.addDefault("Mobs.5.lowest-buy-price", 2.81);
        config.addDefault("Mobs.5.highest-buy-price", 3.90);
        config.addDefault("Mobs.5.lowest-sell-price", 1.21);
        config.addDefault("Mobs.5.highest-sell-price", 2.30);
        config.addDefault("Mobs.6.item", "ENDER_PEARL");
        config.addDefault("Mobs.6.data", 0);
        config.addDefault("Mobs.6.name", "Ender Pearl");
        config.addDefault("Mobs.6.lowest-buy-price", 2.81);
        config.addDefault("Mobs.6.highest-buy-price", 3.90);
        config.addDefault("Mobs.6.lowest-sell-price", 1.21);
        config.addDefault("Mobs.6.highest-sell-price", 2.30);
        config.addDefault("Mobs.7.item", "BLAZE_ROD");
        config.addDefault("Mobs.7.data", 0);
        config.addDefault("Mobs.7.name", "Blaze Rod");
        config.addDefault("Mobs.7.lowest-buy-price", 2.81);
        config.addDefault("Mobs.7.highest-buy-price", 3.90);
        config.addDefault("Mobs.7.lowest-sell-price", 1.21);
        config.addDefault("Mobs.7.highest-sell-price", 2.30);
        config.addDefault("Animals.1.item", "WOOL");
        config.addDefault("Animals.1.data", 0);
        config.addDefault("Animals.1.name", "Wool");
        config.addDefault("Animals.1.lowest-buy-price", 2.81);
        config.addDefault("Animals.1.highest-buy-price", 3.90);
        config.addDefault("Animals.1.lowest-sell-price", 1.21);
        config.addDefault("Animals.1.highest-sell-price", 2.30);
        config.addDefault("Animals.2.item", "FEATHER");
        config.addDefault("Animals.2.data", 0);
        config.addDefault("Animals.2.name", "Feather");
        config.addDefault("Animals.2.lowest-buy-price", 2.81);
        config.addDefault("Animals.2.highest-buy-price", 3.90);
        config.addDefault("Animals.2.lowest-sell-price", 1.21);
        config.addDefault("Animals.2.highest-sell-price", 2.30);
        config.addDefault("Animals.3.item", "LEATHER");
        config.addDefault("Animals.3.data", 0);
        config.addDefault("Animals.3.name", "Leather");
        config.addDefault("Animals.3.lowest-buy-price", 2.81);
        config.addDefault("Animals.3.highest-buy-price", 3.90);
        config.addDefault("Animals.3.lowest-sell-price", 1.21);
        config.addDefault("Animals.3.highest-sell-price", 2.30);
        config.addDefault("Animals.4.item", "RAW_BEEF");
        config.addDefault("Animals.4.data", 0);
        config.addDefault("Animals.4.name", "Raw Beef");
        config.addDefault("Animals.4.lowest-buy-price", 2.81);
        config.addDefault("Animals.4.highest-buy-price", 3.90);
        config.addDefault("Animals.4.lowest-sell-price", 1.21);
        config.addDefault("Animals.4.highest-sell-price", 2.30);
        config.addDefault("Animals.5.item", "RAW_CHICKEN");
        config.addDefault("Animals.5.data", 0);
        config.addDefault("Animals.5.name", "Raw Chicken");
        config.addDefault("Animals.5.lowest-buy-price", 2.81);
        config.addDefault("Animals.5.highest-buy-price", 3.90);
        config.addDefault("Animals.5.lowest-sell-price", 1.21);
        config.addDefault("Animals.5.highest-sell-price", 2.30);
        config.addDefault("Animals.6.item", "PORK");
        config.addDefault("Animals.6.data", 0);
        config.addDefault("Animals.6.name", "Pork");
        config.addDefault("Animals.6.lowest-buy-price", 2.81);
        config.addDefault("Animals.6.highest-buy-price", 3.90);
        config.addDefault("Animals.6.lowest-sell-price", 1.21);
        config.addDefault("Animals.6.highest-sell-price", 2.30);
        config.addDefault("Blocks.1.item", "OBSIDIAN");
        config.addDefault("Blocks.1.data", 0);
        config.addDefault("Blocks.1.name", "Obsidian");
        config.addDefault("Blocks.1.lowest-buy-price", 2.81);
        config.addDefault("Blocks.1.highest-buy-price", 3.90);
        config.addDefault("Blocks.1.lowest-sell-price", 1.21);
        config.addDefault("Blocks.1.highest-sell-price", 2.30);
        config.addDefault("Blocks.2.item", "HARD_CLAY");
        config.addDefault("Blocks.2.data", 0);
        config.addDefault("Blocks.2.name", "Hardened Clay");
        config.addDefault("Blocks.2.lowest-buy-price", 2.81);
        config.addDefault("Blocks.2.highest-buy-price", 3.90);
        config.addDefault("Blocks.2.lowest-sell-price", 1.21);
        config.addDefault("Blocks.2.highest-sell-price", 2.30);
        config.addDefault("Blocks.3.item", "ICE");
        config.addDefault("Blocks.3.data", 0);
        config.addDefault("Blocks.3.name", "Ice");
        config.addDefault("Blocks.3.lowest-buy-price", 2.81);
        config.addDefault("Blocks.3.highest-buy-price", 3.90);
        config.addDefault("Blocks.3.lowest-sell-price", 1.21);
        config.addDefault("Blocks.3.highest-sell-price", 2.30);
        config.addDefault("Blocks.4.item", "GLOWSTONE");
        config.addDefault("Blocks.4.data", 0);
        config.addDefault("Blocks.4.name", "Glowstone");
        config.addDefault("Blocks.4.lowest-buy-price", 2.81);
        config.addDefault("Blocks.4.highest-buy-price", 3.90);
        config.addDefault("Blocks.4.lowest-sell-price", 1.21);
        config.addDefault("Blocks.4.highest-sell-price", 2.30);
        config.addDefault("Blocks.5.item", "GRAVEL");
        config.addDefault("Blocks.5.data", 0);
        config.addDefault("Blocks.5.name", "Gravel");
        config.addDefault("Blocks.5.lowest-buy-price", 2.81);
        config.addDefault("Blocks.5.highest-buy-price", 3.90);
        config.addDefault("Blocks.5.lowest-sell-price", 1.21);
        config.addDefault("Blocks.5.highest-sell-price", 2.30);
        config.addDefault("Blocks.6.item", "SAND");
        config.addDefault("Blocks.6.data", 0);
        config.addDefault("Blocks.6.name", "Sand");
        config.addDefault("Blocks.6.lowest-buy-price", 2.81);
        config.addDefault("Blocks.6.highest-buy-price", 3.90);
        config.addDefault("Blocks.6.lowest-sell-price", 1.21);
        config.addDefault("Blocks.6.highest-sell-price", 2.30);
        config.addDefault("Blocks.7.item", "PRISMARINE");
        config.addDefault("Blocks.7.data", 0);
        config.addDefault("Blocks.7.name", "Prismarine");
        config.addDefault("Blocks.7.lowest-buy-price", 2.81);
        config.addDefault("Blocks.7.highest-buy-price", 3.90);
        config.addDefault("Blocks.7.lowest-sell-price", 1.21);
        config.addDefault("Blocks.7.highest-sell-price", 2.30);
        config.addDefault("Blocks.8.item", "PRISMARINE");
        config.addDefault("Blocks.8.data", 1);
        config.addDefault("Blocks.8.name", "Prismarine Bricks");
        config.addDefault("Blocks.8.lowest-buy-price", 2.81);
        config.addDefault("Blocks.8.highest-buy-price", 3.90);
        config.addDefault("Blocks.8.lowest-sell-price", 1.21);
        config.addDefault("Blocks.8.highest-sell-price", 2.30);
        config.addDefault("Blocks.9.item", "PRISMARINE");
        config.addDefault("Blocks.9.data", 2);
        config.addDefault("Blocks.9.name", "Dark Prismarine");
        config.addDefault("Blocks.9.lowest-buy-price", 2.81);
        config.addDefault("Blocks.9.highest-buy-price", 3.90);
        config.addDefault("Blocks.9.lowest-sell-price", 1.21);
        config.addDefault("Blocks.9.highest-sell-price", 2.30);
        config.addDefault("Others.1.item", "IRON_BARDING");
        config.addDefault("Others.1.data", 0);
        config.addDefault("Others.1.name", "Iron Horse Armor");
        config.addDefault("Others.1.lowest-buy-price", 2.81);
        config.addDefault("Others.1.highest-buy-price", 3.90);
        config.addDefault("Others.1.lowest-sell-price", 1.21);
        config.addDefault("Others.1.highest-sell-price", 2.30);
        config.addDefault("Others.2.item", "GOLD_BARDING");
        config.addDefault("Others.2.data", 0);
        config.addDefault("Others.2.name", "Gold Horse Armor");
        config.addDefault("Others.2.lowest-buy-price", 2.81);
        config.addDefault("Others.2.highest-buy-price", 3.90);
        config.addDefault("Others.2.lowest-sell-price", 1.21);
        config.addDefault("Others.2.highest-sell-price", 2.30);
        config.addDefault("Others.3.item", "DIAMOND_BARDING");
        config.addDefault("Others.3.data", 0);
        config.addDefault("Others.3.name", "Diamond Horse Armor");
        config.addDefault("Others.3.lowest-buy-price", 2.81);
        config.addDefault("Others.3.highest-buy-price", 3.90);
        config.addDefault("Others.3.lowest-sell-price", 1.21);
        config.addDefault("Others.3.highest-sell-price", 2.30);
        config.addDefault("Others.4.item", "SADDLE");
        config.addDefault("Others.4.data", 0);
        config.addDefault("Others.4.name", "Saddle");
        config.addDefault("Others.4.lowest-buy-price", 2.81);
        config.addDefault("Others.4.highest-buy-price", 3.90);
        config.addDefault("Others.4.lowest-sell-price", 1.21);
        config.addDefault("Others.4.highest-sell-price", 2.30);
        config.addDefault("Others.5.item", "APPLE");
        config.addDefault("Others.5.data", 0);
        config.addDefault("Others.5.name", "Apple");
        config.addDefault("Others.5.lowest-buy-price", 2.81);
        config.addDefault("Others.5.highest-buy-price", 3.90);
        config.addDefault("Others.5.lowest-sell-price", 1.21);
        config.addDefault("Others.5.highest-sell-price", 2.30);
        config.addDefault("Others.6.item", "FLINT");
        config.addDefault("Others.6.data", 0);
        config.addDefault("Others.6.name", "Flint");
        config.addDefault("Others.6.lowest-buy-price", 2.81);
        config.addDefault("Others.6.highest-buy-price", 3.90);
        config.addDefault("Others.6.lowest-sell-price", 1.21);
        config.addDefault("Others.6.highest-sell-price", 2.30);
        config.addDefault("Others.7.item", "INK_SACK");
        config.addDefault("Others.7.data", 0);
        config.addDefault("Others.7.name", "Ink Sack");
        config.addDefault("Others.7.lowest-buy-price", 2.81);
        config.addDefault("Others.7.highest-buy-price", 3.90);
        config.addDefault("Others.7.lowest-sell-price", 1.21);
        config.addDefault("Others.7.highest-sell-price", 2.30);
        config.addDefault("Others.8.item", "WEB");
        config.addDefault("Others.8.data", 0);
        config.addDefault("Others.8.name", "Cobweb");
        config.addDefault("Others.8.lowest-buy-price", 2.81);
        config.addDefault("Others.8.highest-buy-price", 3.90);
        config.addDefault("Others.8.lowest-sell-price", 1.21);
        config.addDefault("Others.8.highest-sell-price", 2.30);
        config.addDefault("Others.9.item", "VINE");
        config.addDefault("Others.9.data", 0);
        config.addDefault("Others.9.name", "Vines");
        config.addDefault("Others.9.lowest-buy-price", 2.81);
        config.addDefault("Others.9.highest-buy-price", 3.90);
        config.addDefault("Others.9.lowest-sell-price", 1.21);
        config.addDefault("Others.9.highest-sell-price", 2.30);
        config.options().copyDefaults(true);
        p.saveResource("shopitems.yml", false);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public List<ShopItem> loadShop() {
        List<ShopItem> itemList = new ArrayList<>();
        Random rand = new Random();
        ArrayList<String> allItems = new ArrayList<>(config.getConfigurationSection("Farm").getKeys(false));
        int numberOfElements = 4;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(allItems.size() - 1);
            String cfg = "Farm." + allItems.get(randomIndex) + ".";
            double buyPrice = round(config.getDouble(cfg + "lowest-buy-price") + (config.getDouble(cfg + "highest-buy-price") - config.getDouble(cfg + "lowest-buy-price")) * rand.nextDouble(), 2);
            double sellPrice = round(config.getDouble(cfg + "lowest-sell-price") + (config.getDouble(cfg + "highest-sell-price") - config.getDouble(cfg + "lowest-sell-price")) * rand.nextDouble(), 2);
            itemList.add(new ShopItem(Material.getMaterial(config.getString(cfg + "item")), (byte) config.getInt(cfg + "data"), buyPrice, sellPrice, config.getString(cfg + "name")));
            allItems.remove(randomIndex);
        }
        allItems = new ArrayList<>(config.getConfigurationSection("Mobs").getKeys(false));
        numberOfElements = 3;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(allItems.size() - 1);
            String cfg = "Mobs." + allItems.get(randomIndex) + ".";
            double buyPrice = round(config.getDouble(cfg + "lowest-buy-price") + (config.getDouble(cfg + "highest-buy-price") - config.getDouble(cfg + "lowest-buy-price")) * rand.nextDouble(), 2);
            double sellPrice = round(config.getDouble(cfg + "lowest-sell-price") + (config.getDouble(cfg + "highest-sell-price") - config.getDouble(cfg + "lowest-sell-price")) * rand.nextDouble(), 2);
            itemList.add(new ShopItem(Material.getMaterial(config.getString(cfg + "item")), (byte) config.getInt(cfg + "data"), buyPrice, sellPrice, config.getString(cfg + "name")));
            allItems.remove(randomIndex);
        }
        allItems = new ArrayList<>(config.getConfigurationSection("Animals").getKeys(false));
        numberOfElements = 4;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(allItems.size() - 1);
            String cfg = "Animals." + allItems.get(randomIndex) + ".";
            double buyPrice = round(config.getDouble(cfg + "lowest-buy-price") + (config.getDouble(cfg + "highest-buy-price") - config.getDouble(cfg + "lowest-buy-price")) * rand.nextDouble(), 2);
            double sellPrice = round(config.getDouble(cfg + "lowest-sell-price") + (config.getDouble(cfg + "highest-sell-price") - config.getDouble(cfg + "lowest-sell-price")) * rand.nextDouble(), 2);
            itemList.add(new ShopItem(Material.getMaterial(config.getString(cfg + "item")), (byte) config.getInt(cfg + "data"), buyPrice, sellPrice, config.getString(cfg + "name")));
            allItems.remove(randomIndex);
        }
        allItems = new ArrayList<>(config.getConfigurationSection("Blocks").getKeys(false));
        numberOfElements = 3;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(allItems.size() - 1);
            String cfg = "Blocks." + allItems.get(randomIndex) + ".";
            double buyPrice = round(config.getDouble(cfg + "lowest-buy-price") + (config.getDouble(cfg + "highest-buy-price") - config.getDouble(cfg + "lowest-buy-price")) * rand.nextDouble(), 2);
            double sellPrice = round(config.getDouble(cfg + "lowest-sell-price") + (config.getDouble(cfg + "highest-sell-price") - config.getDouble(cfg + "lowest-sell-price")) * rand.nextDouble(), 2);
            itemList.add(new ShopItem(Material.getMaterial(config.getString(cfg + "item")), (byte) config.getInt(cfg + "data"), buyPrice, sellPrice, config.getString(cfg + "name")));
            allItems.remove(randomIndex);
        }
        allItems = new ArrayList<>(config.getConfigurationSection("Others").getKeys(false));
        numberOfElements = 5;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(allItems.size() - 1);
            String cfg = "Others." + allItems.get(randomIndex) + ".";
            double buyPrice = round(config.getDouble(cfg + "lowest-buy-price") + (config.getDouble(cfg + "highest-buy-price") - config.getDouble(cfg + "lowest-buy-price")) * rand.nextDouble(), 2);
            double sellPrice = round(config.getDouble(cfg + "lowest-sell-price") + (config.getDouble(cfg + "highest-sell-price") - config.getDouble(cfg + "lowest-sell-price")) * rand.nextDouble(), 2);
            itemList.add(new ShopItem(Material.getMaterial(config.getString(cfg + "item")), (byte) config.getInt(cfg + "data"), buyPrice, sellPrice, config.getString(cfg + "name")));
            allItems.remove(randomIndex);
        }
        return itemList;
    }

    public void saveConfig() {
        try {
            config.save(cfile);
        } catch (IOException e) {
            Bukkit.getLogger().severe(ChatColor.RED + "Nu a putut fi salvat config.yml!");
        }
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(cfile);
    }
}
