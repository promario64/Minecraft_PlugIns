package Test.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] strings) {

        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GOLD + "You have been fully restored");
            player.setFoodLevel(20);
            player.setHealth(20);
        }

        return false;
    }
}


