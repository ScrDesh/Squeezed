package straight.squeezin.it.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import straight.squeezin.it.ModBlocks;
import straight.squeezin.it.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                offerPlanksRecipe(ModBlocks.BLIGHTED_PLANKS,ModTags.Items.BLIGHTED_LOGS,4);
                offerBarkBlockRecipe(ModBlocks.BLIGHTED_WOOD, ModBlocks.BLIGHTED_LOG);
                offerBarkBlockRecipe(ModBlocks.STRIPPED_BLIGHTED_WOOD, ModBlocks.STRIPPED_BLIGHTED_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.END_STONE_PILLAR, Blocks.END_STONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.END_STONE_TILES, Blocks.END_STONE);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
