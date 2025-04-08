package qinomed.kubejsdelight.recipe;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.component.TimeComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.util.TickDuration;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public interface CookingRecipeJS {
    RecipeKey<List<Ingredient>> INGREDIENTS = IngredientComponent.INGREDIENT.asList().inputKey("ingredients");
    RecipeKey<ItemStack> RESULT = ItemStackComponent.ITEM_STACK.outputKey("result");
    RecipeKey<ItemStack> CONTAINER = ItemStackComponent.ITEM_STACK.inputKey("container").defaultOptional();
    RecipeKey<Integer> EXPERIENCE = NumberComponent.INT.otherKey("experience").alt("exp", "xp").optional(0);
    RecipeKey<TickDuration> TIME = TimeComponent.TICKS.otherKey("cookingtime").alt("time").optional(TickDuration.ZERO);

    RecipeSchema SCHEMA = new RecipeSchema(INGREDIENTS, RESULT, CONTAINER, EXPERIENCE, TIME);
}