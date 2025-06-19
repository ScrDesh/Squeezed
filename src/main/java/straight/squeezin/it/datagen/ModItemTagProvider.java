package straight.squeezin.it.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import straight.squeezin.it.ModBlocks;
import straight.squeezin.it.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.BLIGHTED_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLIGHTED_LOG.asItem())
                .add(ModBlocks.STRIPPED_BLIGHTED_LOG.asItem())
                .add(ModBlocks.BLIGHTED_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BLIGHTED_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ModBlocks.BLIGHTED_LEAVES.asItem());
        getOrCreateTagBuilder(ModTags.Items.BLIGHTED_LOGS)
                .add(ModBlocks.BLIGHTED_LOG.asItem())
                .add(ModBlocks.STRIPPED_BLIGHTED_LOG.asItem())
                .add(ModBlocks.BLIGHTED_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BLIGHTED_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.BLIGHTED_SAPLING.asItem());
    }
}
