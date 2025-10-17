package qinomed.kubejsdelight.recipe.component;

import dev.latvian.mods.kubejs.recipe.component.EnumComponent;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import qinomed.kubejsdelight.KubeJSDelight;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;

public class FDRecipeBookTabComponent {
    public static final RecipeComponentType<CookingPotRecipeBookTab> RECIPE_BOOK_TAB_COMPONENT = EnumComponent.of(
            ResourceLocation.fromNamespaceAndPath(KubeJSDelight.MODID, "cooking_pot_recipe_book_tab"),
            CookingPotRecipeBookTab.class,
            StringRepresentable.fromEnum(CookingPotRecipeBookTab::values)
    );
}
