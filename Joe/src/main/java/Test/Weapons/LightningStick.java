package Test.Weapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class LightningStick extends ItemStack implements Listener {

    public LightningStick() {
        super(Material.STICK);
        ItemMeta stickMeta = getItemMeta();
        stickMeta.setDisplayName(ChatColor.MAGIC + "FUNTIMELIGHTING");
        stickMeta.setLore(Arrays.asList(ChatColor.GOLD + "A little bit of Magic"));
        setItemMeta(stickMeta);
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();

        // Check if the player is holding the LightningStick
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if (itemInHand != null && itemInHand.getType() == Material.STICK) {
            ItemMeta itemMeta = itemInHand.getItemMeta();
            if (itemMeta != null && itemMeta.getDisplayName() != null && itemMeta.getDisplayName().equals(ChatColor.MAGIC + "FUNTIMELIGHTING")) {
                // Player is holding the LightningStick, strike lightning at the entity's location
                entity.getWorld().strikeLightning(entity.getLocation());
            }
        }
    }
}

