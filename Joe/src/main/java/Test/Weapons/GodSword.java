package Test.Weapons;
import Test.Enchant.Enchating;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GodSword extends ItemStack {

    public GodSword() {
        super(Material.DIAMOND_SWORD);
        ItemMeta GodMeta = getItemMeta();
        GodMeta.setDisplayName(ChatColor.DARK_RED + "Thor's Hammer");
        GodMeta.setLore(Arrays.asList(ChatColor.GOLD + "Summon the power of Thor"));
        setItemMeta(GodMeta);

        // Apply custom enchantments using the addUnsafeEnchantment method
        addUnsafeEnchantment(Enchating.DAMAGE_ALL,100);

    }

}





