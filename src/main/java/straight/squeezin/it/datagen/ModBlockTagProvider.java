package straight.squeezin.it.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import straight.squeezin.it.ModBlocks;
import straight.squeezin.it.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup){
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.END_STONE_PILLAR)
                .add(ModBlocks.END_STONE_TILES)
                .add(ModBlocks.CHISELED_END_STONE)
                .add(ModBlocks.BLIGHTED_GRASS)
                .add(ModBlocks.SMOOTH_END_STONE)
                .add(ModBlocks.COAGULATED_NACRE)
                .add(ModBlocks.DULL_NACRE);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.BLIGHTED_PLANKS)
                .add(ModBlocks.BLIGHTED_LOG)
                .add(ModBlocks.STRIPPED_BLIGHTED_LOG)
                .add(ModBlocks.BLIGHTED_WOOD)
                .add(ModBlocks.STRIPPED_BLIGHTED_WOOD);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.BLIGHTED_VINES)
                .add(ModBlocks.BLIGHTED_LEAVES);
        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.SMOOTH_END_STONE)
                .add(ModBlocks.COAGULATED_NACRE);
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.BLIGHTED_PLANKS);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLIGHTED_LOG)
                .add(ModBlocks.STRIPPED_BLIGHTED_LOG)
                .add(ModBlocks.BLIGHTED_WOOD)
                .add(ModBlocks.STRIPPED_BLIGHTED_WOOD);
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.BLIGHTED_LEAVES);
        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(ModBlocks.BLIGHTED_VINES);
        getOrCreateTagBuilder(ModTags.Blocks.BLIGHTED_LOGS)
                .add(ModBlocks.BLIGHTED_LOG)
                .add(ModBlocks.STRIPPED_BLIGHTED_LOG)
                .add(ModBlocks.BLIGHTED_WOOD)
                .add(ModBlocks.STRIPPED_BLIGHTED_WOOD);
    }
}
