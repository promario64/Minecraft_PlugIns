package Test.Enchant;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.bukkit.NamespacedKey;

public class Enchating extends Enchantment {

    public Enchating(NamespacedKey key) {
        super(key);
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return true; // You can define specific item checks here
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false; // It doesn't conflict with other enchantments
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ALL; // You can specify the target here
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public int getMaxLevel() {
        return 2; // Maximum level for this enchantment
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    @Override
    public String getName() {
        return "SPICY"; // The name of your enchantment
    }
}


