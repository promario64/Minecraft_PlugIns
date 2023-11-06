package Test.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Craft implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] strings)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            player.openWorkbench(null,true);
        }

        return false;
    }
}
