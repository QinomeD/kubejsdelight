package qinomed.kubejsdelight.recipe;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.EnumComponent;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public interface CookingRecipeJS {
    enum RecipeBookTypes implements StringRepresentable {
        MEALS("meals"),
        DRINKS("drinks"),
        MISC("misc");
        final String name;

        RecipeBookTypes(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }

    RecipeKey<List<Ingredient>> INGREDIENTS = IngredientComponent.NON_EMPTY_INGREDIENT.asList().inputKey("ingredients");
    RecipeKey<ItemStack> RESULT = ItemStackComponent.ITEM_STACK.outputKey("result");
    RecipeKey<ItemStack> CONTAINER = ItemStackComponent.ITEM_STACK.inputKey("container").defaultOptional();
    RecipeKey<Float> EXPERIENCE = NumberComponent.FLOAT.otherKey("experience").optional(0f);
    RecipeKey<Integer> TIME = NumberComponent.INT.otherKey("cookingtime").optional(200);
    RecipeKey<RecipeBookTypes> RECIPE_BOOK_TAB = EnumComponent.of("cooking_pot_recipe_book_tab", RecipeBookTypes.class, StringRepresentable.fromEnum(RecipeBookTypes::values)).otherKey("recipe_book_tab");

    RecipeSchema SCHEMA = new RecipeSchema(RECIPE_BOOK_TAB, INGREDIENTS, RESULT, EXPERIENCE, TIME, CONTAINER);
}