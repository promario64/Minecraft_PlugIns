package Test;

import Test.Commands.*;
import Test.Weapons.*;
import Test.Menu.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Plugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("DEBUG :::: Plugin Has Started\n");

        getServer().getPluginManager().registerEvents(new LightningStick(), this);
        getServer().getPluginManager().registerEvents(new TP_Shove(),this);

        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("Heal").setExecutor(new Heal());
        getCommand("Craft").setExecutor(new Craft());
        getCommand("Menu").setExecutor(new MenuCommand());


    }

    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        if(ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.GOLD.toString() + ChatColor.BOLD  + "Illegal Shop") && e.getCurrentItem() != null)
        {
            Player player = (Player) e.getWhoClicked();

            switch (e.getRawSlot())
            {
                case 0:
                    break;

                case 20:

                    LightningStick FlashStick = new LightningStick();

                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(FlashStick); // add lighting stick
                    } else {
                        player.sendMessage(ChatColor.RED + "Your inventory is full!");
                    }
                    break;

                case 22:
                    GodSword godSword = new GodSword();

                    // Check if the player's inventory has space for the item
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(godSword);
                    } else {
                        player.sendMessage(ChatColor.RED + "Your inventory is full!");
                    }

                    break;

                case 24:

                    TP_Shove TPShove = new TP_Shove();

                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(TPShove);
                    } else {
                        player.sendMessage(ChatColor.RED + "Your inventory is full!");
                    }

                    break;

                default:
                    return;
            }


            player.closeInventory();
        }


    }





}
