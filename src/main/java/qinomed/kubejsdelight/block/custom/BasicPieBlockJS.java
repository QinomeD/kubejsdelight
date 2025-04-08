package qinomed.kubejsdelight.block.custom;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.Supplier;

public class BasicPieBlockJS extends PieBlock {
    public BasicPieBlockJS(PieBlockBuilder builder) {
        super(builder.createProperties(), () -> BuiltInRegistries.ITEM.get(builder.sliceItem));
    }

    public BasicPieBlockJS(Properties properties, Supplier<Item> pieSlice) {
        super(properties, pieSlice);
    }
}
