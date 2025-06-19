package straight.squeezin.it;

import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.sound.*;
import net.minecraft.util.*;
import straight.squeezin.it.block.*;
import straight.squeezin.it.world.tree.ModSaplingGenerators;

import java.util.function.Function;

public class ModBlocks {
    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Squeezed.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Squeezed.MOD_ID, name));
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItems.SQUEEZED_ITEMGROUP_MCD_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.SMOOTH_END_STONE.asItem());
            itemGroup.add(ModBlocks.END_STONE_PILLAR.asItem());
            itemGroup.add(ModBlocks.END_STONE_TILES.asItem());
            itemGroup.add(ModBlocks.CHISELED_END_STONE.asItem());
            itemGroup.add(ModBlocks.COAGULATED_NACRE.asItem());
            itemGroup.add(ModBlocks.DULL_NACRE.asItem());
            itemGroup.add(ModBlocks.TEKTITE_PILLAR.asItem());
            itemGroup.add(ModBlocks.VOID_LURE.asItem());
            itemGroup.add(ModBlocks.BLIGHTED_GRASS.asItem());
            itemGroup.add(ModBlocks.BLIGHTED_LOG.asItem());
            itemGroup.add(ModBlocks.BLIGHTED_WOOD.asItem());
            itemGroup.add(ModBlocks.STRIPPED_BLIGHTED_LOG.asItem());
            itemGroup.add(ModBlocks.STRIPPED_BLIGHTED_WOOD.asItem());
            itemGroup.add(ModBlocks.BLIGHTED_PLANKS.asItem());
            itemGroup.add(ModBlocks.BLIGHTED_LEAVES.asItem());
            itemGroup.add(ModBlocks.BLIGHTED_VINES.asItem());
            itemGroup.add(ModBlocks.BLIGHTED_SAPLING.asItem());
        });
        ItemGroupEvents.modifyEntriesEvent(ModItems.SQUEEZED_ITEMGROUP_MAIN_KEY).register((itemGroup) -> {

        });
    }


    public static final Block BLIGHTED_GRASS = register(
            "blighted_grass",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(3,9).sounds(BlockSoundGroup.NYLIUM),
            true
    );
    public static final Block SMOOTH_END_STONE = register(
            "smooth_end_stone",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(3,9).sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block COAGULATED_NACRE = register(
            "coagulated_nacre",
            MudBlock::new,
            AbstractBlock.Settings.create().requiresTool().strength(1.5f,9).sounds(BlockSoundGroup.CORAL),
            true
    );
    public static final Block DULL_NACRE = register(
            "dull_nacre",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(1.5f,9).sounds(BlockSoundGroup.CALCITE),
            true
    );
    public static final Block TEKTITE_PILLAR = register(
            "tektite_pillar",
            PillarBlock::new,
            AbstractBlock.Settings.create().requiresTool().strength(1,15).sounds(BlockSoundGroup.DEEPSLATE_TILES),
            true
    );
    public static final Block END_STONE_PILLAR = register(
            "end_stone_pillar",
            PillarBlock::new,
            AbstractBlock.Settings.create().requiresTool().strength(3,9).sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block END_STONE_TILES = register(
            "end_stone_tiles",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(3,9).sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block CHISELED_END_STONE = register(
            "chiseled_end_stone",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(3,9).sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block VOID_LURE = register(
            "void_lure",
            Block::new,
            AbstractBlock.Settings.create().strength(1,1).emissiveLighting((a,b,c)->true).luminance(a->15).sounds(BlockSoundGroup.WOOD),
            true
    );
    public static final Block BLIGHTED_PLANKS = register(
            "blighted_planks",
            Block::new,
            AbstractBlock.Settings.create().strength(2,3).sounds(BlockSoundGroup.NETHER_WOOD),
            true
    );
    public static final Block BLIGHTED_LOG = register(
            "blighted_log",
            PillarBlock::new,
            AbstractBlock.Settings.create().strength(2,2).sounds(BlockSoundGroup.NETHER_WOOD),
            true
    );
    public static final Block BLIGHTED_WOOD = register(
            "blighted_wood",
            PillarBlock::new,
            AbstractBlock.Settings.create().strength(2,2).sounds(BlockSoundGroup.NETHER_WOOD),
            true
    );
    public static final Block STRIPPED_BLIGHTED_LOG = register(
            "stripped_blighted_log",
            PillarBlock::new,
            AbstractBlock.Settings.create().strength(2,2).sounds(BlockSoundGroup.NETHER_WOOD),
            true
    );
    public static final Block STRIPPED_BLIGHTED_WOOD = register(
            "stripped_blighted_wood",
            PillarBlock::new,
            AbstractBlock.Settings.create().strength(2,2).sounds(BlockSoundGroup.NETHER_WOOD),
            true
    );
    public static final Block BLIGHTED_LEAVES = register(
            "blighted_leaves",
            BlightedLeavesBlock::new,
            AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES),
            true
    );
    public static final Block BLIGHTED_VINES = register(
            "blighted_vines",
            BlightedVineBlock::new,
            AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES),
            true
    );
    public static final Block BLIGHTED_SAPLING = register(
            "blighted_sapling",
            (a) -> new SaplingBlock(ModSaplingGenerators.BLIGHTED, a),
            AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.CHERRY_SAPLING),
            true
    );
}