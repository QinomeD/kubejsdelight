package qinomed.kubejsdelight.recipe.component;

import com.mojang.serialization.Codec;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.rhino.type.TypeInfo;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class SoundEventComponent implements RecipeComponent<SoundEvent> {
    public static final SoundEventComponent SOUND = new SoundEventComponent();

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
