package straight.squeezin.it.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import straight.squeezin.it.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate(){
        addDrop(ModBlocks.BLIGHTED_GRASS);
        addDrop(ModBlocks.BLIGHTED_LOG);
        addDrop(ModBlocks.STRIPPED_BLIGHTED_LOG);
        addDrop(ModBlocks.BLIGHTED_WOOD);
        addDrop(ModBlocks.STRIPPED_BLIGHTED_WOOD);
        addDrop(ModBlocks.BLIGHTED_LEAVES, leavesDrops(ModBlocks.BLIGHTED_LEAVES, Blocks.OAK_SAPLING, 0.0625f));
        addDrop(ModBlocks.BLIGHTED_VINES, dropsWithSilkTouchOrShears(ModBlocks.BLIGHTED_VINES.asItem()));
        addDrop(ModBlocks.END_STONE_PILLAR);
        addDrop(ModBlocks.END_STONE_TILES);
        addDrop(ModBlocks.SMOOTH_END_STONE);
        addDrop(ModBlocks.SETTLED_END_STONE);
        addDrop(ModBlocks.LAYERED_END_STONE);
        addDrop(ModBlocks.LAYERED_VOID_SHALE);
        addDrop(ModBlocks.VOID_SHALE);
    }
}
