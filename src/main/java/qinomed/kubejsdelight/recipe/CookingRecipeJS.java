package qinomed.kubejsdelight.recipe;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.*;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import qinomed.kubejsdelight.recipe.component.FDRecipeBookTabComponent;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;

import java.util.List;

public interface CookingRecipeJS {
    RecipeKey<List<Ingredient>> INGREDIENTS = IngredientComponent.INGREDIENT.instance().asList().inputKey("ingredients");
    RecipeKey<ItemStack> RESULT = ItemStackComponent.ITEM_STACK.outputKey("result");
    RecipeKey<ItemStack> CONTAINER = ItemStackComponent.ITEM_STACK.inputKey("container").defaultOptional();
    RecipeKey<Float> EXPERIENCE = NumberComponent.FLOAT.otherKey("experience").optional(0f);
    RecipeKey<Integer> TIME = NumberComponent.INT.otherKey("cookingtime").optional(200);
    RecipeKey<CookingPotRecipeBookTab> RECIPE_BOOK_TAB = FDRecipeBookTabComponent.RECIPE_BOOK_TAB_COMPONENT.otherKey("recipe_book_tab");

    RecipeSchema SCHEMA = new RecipeSchema(RECIPE_BOOK_TAB, INGREDIENTS, RESULT, EXPERIENCE, TIME, CONTAINER);
}