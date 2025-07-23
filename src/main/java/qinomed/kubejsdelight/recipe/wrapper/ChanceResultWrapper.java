package qinomed.kubejsdelight.recipe.wrapper;

import dev.latvian.mods.kubejs.item.ItemStackJS;
import dev.latvian.mods.kubejs.util.RegistryAccessContainer;
import dev.latvian.mods.rhino.Wrapper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;

public interface ChanceResultWrapper {
    static ChanceResult of(ChanceResult chanceResult) {
        return chanceResult;
    }

    static ChanceResult of(ItemStack stack, float chance) {
        return new ChanceResult(stack, chance);
    }

    static ChanceResult wrap(RegistryAccessContainer registries, @Nullable Object o) {
        while (o instanceof Wrapper w) {
            o = w.unwrap();
        }

        if (o == null || o == ItemStack.EMPTY || o == Items.AIR || o == Ingredient.EMPTY) {
            return new ChanceResult(ItemStack.EMPTY, 0);
        }

        return new ChanceResult(ItemStackJS.wrap(registries, o), 1);
    }
}
