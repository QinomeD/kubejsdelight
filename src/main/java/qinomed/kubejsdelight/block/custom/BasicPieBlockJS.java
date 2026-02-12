package qinomed.kubejsdelight.block.custom;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.Supplier;

public class BasicPieBlockJS extends PieBlock {
    protected final int bites;

    public BasicPieBlockJS(PieBlockBuilder builder) {
        super(builder.createProperties(), () -> ForgeRegistries.ITEMS.getValue(builder.sliceItem));
        bites = builder.bites;
    }

    @Override
    public int getMaxBites() {
        return bites;
    }

    public BasicPieBlockJS(Properties properties, Supplier<Item> pieSlice) {
        super(properties, pieSlice);
        bites = 4;
    }
}
