package Test.Menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player)
        {
            Player player = (Player) commandSender;


            Inventory Invi = Bukkit.createInventory(player, 45, ChatColor.GOLD.toString() + ChatColor.BOLD  + "Illegal Shop");


            // Stick of truth
            ItemStack Stick_of_truth = new ItemStack(Material.STICK);
            ItemMeta MetaStick = Stick_of_truth.getItemMeta();
            MetaStick.setDisplayName(ChatColor.MAGIC + "dnddddddddd");
            MetaStick.setLore(Arrays.asList(ChatColor.GOLD + "A little bit of Magic"));
            Stick_of_truth.setItemMeta(MetaStick);
            Invi.setItem(20,Stick_of_truth);

            // Thors hammer
            ItemStack God_Sword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta GodMeta = God_Sword.getItemMeta();
            GodMeta.setDisplayName(ChatColor.DARK_RED +"Thor's Hammer");
            GodMeta.setLore(Arrays.asList(ChatColor.GOLD + "Summon the power of Thor"));
            God_Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL,10);
            God_Sword.setItemMeta(GodMeta);
            Invi.setItem(22,God_Sword);

            // TP Shovel

            ItemStack TP_Shove = new ItemStack(Material.DIAMOND_SHOVEL);
            ItemMeta MetaTP = TP_Shove.getItemMeta();
            MetaTP.setDisplayName(ChatColor.DARK_BLUE + "Enders Wish");
            MetaTP.setLore(Arrays.asList(ChatColor.DARK_RED + "Telport 8 Block ahead"));
            AttributeModifier MoveSpeed = new AttributeModifier("Movment Mod", 0.1589,AttributeModifier.Operation.ADD_NUMBER);
            MetaTP.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, MoveSpeed);
            TP_Shove.setItemMeta(MetaTP);
            Invi.setItem(24,TP_Shove);

            // Close menu

            ItemStack Close = new ItemStack(Material.BARRIER);
            ItemMeta CloseMeta = Close.getItemMeta();
            CloseMeta.setDisplayName(ChatColor.DARK_RED + "CLOSE");
            Close.setItemMeta(CloseMeta);
            Invi.setItem(0,Close);

            // FRAME

            ItemStack Frame = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);

            for (int i : new int[]{1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44})
            {
                Invi.setItem(i,Frame);
            }

            player.openInventory(Invi);
        }
        return false;
    }
}
