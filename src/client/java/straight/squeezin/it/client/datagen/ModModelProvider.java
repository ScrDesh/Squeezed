package straight.squeezin.it.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import straight.squeezin.it.ModBlocks;
import straight.squeezin.it.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DULL_NACRE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLIGHTED_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLIGHTED_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_END_STONE);
        blockStateModelGenerator.registerMirrorable(ModBlocks.SMOOTH_END_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_LURE);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.END_STONE_PILLAR).log(ModBlocks.END_STONE_PILLAR);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.TEKTITE_PILLAR).log(ModBlocks.TEKTITE_PILLAR);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.BLIGHTED_LOG).log(ModBlocks.BLIGHTED_LOG).wood(ModBlocks.BLIGHTED_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_BLIGHTED_LOG).log(ModBlocks.STRIPPED_BLIGHTED_LOG).wood(ModBlocks.STRIPPED_BLIGHTED_WOOD);
        blockStateModelGenerator.registerRandomHorizontalRotations(TexturedModel.CUBE_BOTTOM_TOP, ModBlocks.BLIGHTED_GRASS);
        blockStateModelGenerator.registerRandomHorizontalRotations(TexturedModel.END_FOR_TOP_CUBE_COLUMN, ModBlocks.COAGULATED_NACRE);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.BLIGHTED_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ModBlocks.BLIGHTED_VINES.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLIGHTED_SAPLING.asItem(), Models.GENERATED);
    }

    @Override
    public String getName() {
        return "Squeezed Model Provider";
    }
}
