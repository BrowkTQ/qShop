package me.Browk.qShop;

import me.Browk.qShop.Handlers.ConfigHandler;
import me.Browk.qShop.Listener.CommandListener;
import me.Browk.qShop.Listener.InventoryClickListener;
import me.Browk.qShop.Shop.ShopUtils;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Utils {

    public static Main instance;
    public static Economy econ;

    @Override
    public void onEnable() {
        this.instance = this;

        if (!setupEconomy()) {
            sendLogger("You must have Vault installed!");
            Bukkit.shutdown();
            return;
        }

        ConfigHandler settings = ConfigHandler.getInstance();
        settings.setup(this);
        ShopUtils.generateShop();
        getCommand("qshop").setExecutor(new CommandListener());
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    @Override
    public void onDisable() {
    }
}
