package Test.Weapons;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.Arrays;

public class TP_Shove extends ItemStack implements Listener {


    public TP_Shove()
    {
        super(Material.DIAMOND_SHOVEL);
       ItemMeta ShovelMeta = getItemMeta();
        ShovelMeta.setDisplayName(ChatColor.DARK_BLUE + "Enders Wish");
        ShovelMeta.setLore(Arrays.asList(ChatColor.DARK_BLUE + "Telport 8 Block ahead"));
        AttributeModifier MoveSpeed = new AttributeModifier("Movment Mod", 0.1589,AttributeModifier.Operation.ADD_NUMBER);
        ShovelMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, MoveSpeed);
        setItemMeta(ShovelMeta);
    }

    public void TeleportDirection(Player player)
    {
        // Get the player's current location
        Location playerLocation = player.getLocation();

        // Get the player's yaw (horizontal rotation) and pitch (vertical rotation) angles
        float yaw = playerLocation.getYaw();
        float pitch = playerLocation.getPitch();

        // Calculate the direction vector using yaw and pitch
        double x = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        double y = -Math.sin(Math.toRadians(pitch));
        double z = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));

        // Normalize the direction vector
        Vector direction = new Vector(x, y, z).normalize();

        // Multiply the direction vector by the desired distance (e.g., 8 blocks)
        direction.multiply(8);

        // Add the new direction vector to the player's current location
        Location destination = playerLocation.add(direction);

        // Teleport the player to the calculated destination
        player.teleport(destination);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

        if (itemInMainHand.hasItemMeta()) {
            ItemMeta itemMeta = itemInMainHand.getItemMeta();
            if (itemMeta.hasDisplayName() && ChatColor.stripColor(itemMeta.getDisplayName()).equals("Enders Wish") && event.getAction() == Action.RIGHT_CLICK_AIR) {
                TeleportDirection(player);
            }
        }
    }


}
