package me.Browk.qShop.Listener;

import me.Browk.qShop.Shop.ShopUtils;
import me.Browk.qShop.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor, Utils {
    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] argument) {
        if (!(sender instanceof Player)) {
            noConsole(sender);
            return true;
        }
        Player player = (Player) sender;
        ShopUtils.openShop(player);
        return true;
    }
}
