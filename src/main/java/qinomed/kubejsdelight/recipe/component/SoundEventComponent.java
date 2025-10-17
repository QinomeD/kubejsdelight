package qinomed.kubejsdelight.recipe.component;

import com.mojang.serialization.Codec;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentType;
import dev.latvian.mods.rhino.type.TypeInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import qinomed.kubejsdelight.KubeJSDelight;

public record SoundEventComponent(RecipeComponentType<?> type) implements RecipeComponent<SoundEvent> {
    public static final RecipeComponentType<SoundEvent> SOUND = RecipeComponentType.unit(
            ResourceLocation.fromNamespaceAndPath(KubeJSDelight.MODID, "sound"),
            SoundEventComponent::new
    );

    @Override
    public Codec<SoundEvent> codec() {
        return SoundEvent.DIRECT_CODEC;
    }

    @Override
    public TypeInfo typeInfo() {
        return TypeInfo.of(SoundEvent.class);
    }

    @Override
    public boolean isEmpty(SoundEvent value) {
        return value.equals(SoundEvents.EMPTY);
    }
}
