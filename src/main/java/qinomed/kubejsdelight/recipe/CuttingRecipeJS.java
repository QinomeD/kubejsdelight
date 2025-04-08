package qinomed.kubejsdelight.recipe;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.StringComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public interface CuttingRecipeJS {
    RecipeKey<List<Ingredient>> INPUT = IngredientComponent.INGREDIENT.asList().inputKey("ingredients");
    RecipeKey<Ingredient> TOOL = IngredientComponent.INGREDIENT.otherKey("tool");
    RecipeKey<List<ItemStack>> RESULTS = ItemStackComponent.ITEM_STACK.asListOrSelf().outputKey("result");
    RecipeKey<String> SOUND = StringComponent.ANY.otherKey("sound").optional("").allowEmpty();

    RecipeSchema SCHEMA = new RecipeSchema(INPUT, TOOL, RESULTS, SOUND);
}