package Test.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class bal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] strings) {

        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            Object Balence = 0;
            player.sendMessage(ChatColor.DARK_RED + "You have: $" + Balence);

        }




        return false;
    }
}
