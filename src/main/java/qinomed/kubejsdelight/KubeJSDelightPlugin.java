package qinomed.kubejsdelight;

import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchemaRegistry;
import dev.latvian.mods.kubejs.registry.BuilderTypeRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import qinomed.kubejsdelight.block.custom.FeastBlockBuilder;
import qinomed.kubejsdelight.item.custom.KnifeItemBuilder;
import qinomed.kubejsdelight.block.custom.PieBlockBuilder;
import qinomed.kubejsdelight.recipe.CookingRecipeJS;
import qinomed.kubejsdelight.recipe.CuttingRecipeJS;

public class KubeJSDelightPlugin implements KubeJSPlugin {
    @Override
    public void registerRecipeSchemas(RecipeSchemaRegistry registry) {
        registry.register(ResourceLocation.parse("farmersdelight:cutting"), CuttingRecipeJS.SCHEMA);
        registry.register(ResourceLocation.parse("farmersdelight:cooking"), CookingRecipeJS.SCHEMA);
    }

    @Override
    public void registerBuilderTypes(BuilderTypeRegistry registry) {
        registry.of(Registries.BLOCK, reg -> {
            reg.add("farmersdelight:pie", PieBlockBuilder.class, PieBlockBuilder::new);
            reg.add("farmersdelight:feast", FeastBlockBuilder.class, FeastBlockBuilder::new);
        });

        registry.of(Registries.ITEM, reg -> {
            reg.add("farmersdelight:knife", KnifeItemBuilder.class, KnifeItemBuilder::new);
        });
    }
}
