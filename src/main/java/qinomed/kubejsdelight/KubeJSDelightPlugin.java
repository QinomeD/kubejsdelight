package qinomed.kubejsdelight;

import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentTypeRegistry;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchemaRegistry;
import dev.latvian.mods.kubejs.registry.BuilderTypeRegistry;
import dev.latvian.mods.kubejs.script.BindingRegistry;
import dev.latvian.mods.kubejs.script.TypeWrapperRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import qinomed.kubejsdelight.block.custom.FeastBlockBuilder;
import qinomed.kubejsdelight.item.custom.KnifeItemBuilder;
import qinomed.kubejsdelight.block.custom.PieBlockBuilder;
import qinomed.kubejsdelight.recipe.CookingRecipeJS;
import qinomed.kubejsdelight.recipe.CuttingRecipeJS;
import qinomed.kubejsdelight.recipe.component.ChanceResultComponent;
import qinomed.kubejsdelight.recipe.component.FDRecipeBookTabComponent;
import qinomed.kubejsdelight.recipe.component.SoundEventComponent;
import qinomed.kubejsdelight.recipe.wrapper.ChanceResultWrapper;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;

public class KubeJSDelightPlugin implements KubeJSPlugin {
    @Override
    public void registerRecipeSchemas(RecipeSchemaRegistry registry) {
        registry.register(ResourceLocation.parse("farmersdelight:cutting"), CuttingRecipeJS.SCHEMA);
        registry.register(ResourceLocation.parse("farmersdelight:cooking"), CookingRecipeJS.SCHEMA);
    }

    @Override
    public void registerBuilderTypes(BuilderTypeRegistry registry) {
        registry.of(Registries.BLOCK, reg -> {
            reg.add(ResourceLocation.parse("farmersdelight:pie"), PieBlockBuilder.class, PieBlockBuilder::new);
            reg.add(ResourceLocation.parse("farmersdelight:feast"), FeastBlockBuilder.class, FeastBlockBuilder::new);
        });

        registry.of(Registries.ITEM, reg -> {
            reg.add(ResourceLocation.parse("farmersdelight:knife"), KnifeItemBuilder.class, KnifeItemBuilder::new);
        });
    }

    @Override
    public void registerRecipeComponents(RecipeComponentTypeRegistry registry) {
        registry.register(ChanceResultComponent.CHANCE_RESULT);
        registry.register(SoundEventComponent.SOUND);
        registry.register(FDRecipeBookTabComponent.RECIPE_BOOK_TAB_COMPONENT);
    }

    @Override
    public void registerBindings(BindingRegistry bindings) {
        bindings.add("ChanceResult", ChanceResultWrapper.class);
    }

    @Override
    public void registerTypeWrappers(TypeWrapperRegistry registry) {
        registry.register(ChanceResult.class, ChanceResultWrapper::wrap);
    }
}
