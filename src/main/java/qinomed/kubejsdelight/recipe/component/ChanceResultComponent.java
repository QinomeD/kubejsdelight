package qinomed.kubejsdelight.recipe.component;

import com.mojang.serialization.Codec;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.recipe.match.ItemMatch;
import dev.latvian.mods.kubejs.recipe.match.ReplacementMatchInfo;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.type.TypeInfo;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;

public class ChanceResultComponent implements RecipeComponent<ChanceResult> {
    public static final ChanceResultComponent RESULT = new ChanceResultComponent();

    @Override
    public Codec<ChanceResult> codec() {
        return ChanceResult.CODEC;
    }

    @Override
    public TypeInfo typeInfo() {
        return TypeInfo.of(ChanceResult.class);
    }

    @Override
    public boolean matches(Context cx, KubeRecipe recipe, ChanceResult value, ReplacementMatchInfo matchInfo) {
        if (matchInfo.match() instanceof ItemMatch itemMatch) {
            return !value.stack().isEmpty() && itemMatch.matches(cx, value.stack(), matchInfo.exact());
        }

        return false;
    }

    @Override
    public boolean isEmpty(ChanceResult value) {
        return value.stack().isEmpty();
    }

    @Override
    public String toString() {
        return "chance_result";
    }
}
