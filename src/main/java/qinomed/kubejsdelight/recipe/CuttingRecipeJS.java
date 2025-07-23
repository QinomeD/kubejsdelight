package qinomed.kubejsdelight.recipe;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.crafting.Ingredient;
import qinomed.kubejsdelight.recipe.component.ChanceResultComponent;
import qinomed.kubejsdelight.recipe.component.SoundEventComponent;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;

import java.util.List;

public interface CuttingRecipeJS {
    RecipeKey<List<Ingredient>> INPUT = IngredientComponent.NON_EMPTY_INGREDIENT.asList().inputKey("ingredients");
    RecipeKey<Ingredient> TOOL = IngredientComponent.INGREDIENT.inputKey("tool");
    RecipeKey<List<ChanceResult>> RESULTS = ChanceResultComponent.RESULT.asList().outputKey("result");
    RecipeKey<SoundEvent> SOUND = SoundEventComponent.SOUND.otherKey("sound").defaultOptional().allowEmpty();

    RecipeSchema SCHEMA = new RecipeSchema(INPUT, TOOL, RESULTS, SOUND);
}