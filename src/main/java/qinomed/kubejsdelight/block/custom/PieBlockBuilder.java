package qinomed.kubejsdelight.block.custom;

import dev.latvian.mods.kubejs.block.BlockBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PieBlockBuilder extends BlockBuilder {
    public transient ResourceLocation sliceItem;
    public transient int bites;

    public PieBlockBuilder(ResourceLocation i) {
        super(i);
        sliceItem = ResourceLocation.parse("minecraft:air");
        bites = 4;
    }

    public PieBlockBuilder sliceItem(ResourceLocation s) {
        this.sliceItem = s;
        return this;
    }

    public PieBlockBuilder bites(int i) {
        this.bites = i;
        return this;
    }

    @Override
    public Block createObject() {
        return new BasicPieBlockJS(this);
    }
}
