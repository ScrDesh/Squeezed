package straight.squeezin.it;

import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.sound.*;
import net.minecraft.util.*;

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
            itemGroup.add(ModBlocks.BLIGHTED_GRASS.asItem());
            itemGroup.add(ModBlocks.SMOOTH_END_STONE.asItem());
            itemGroup.add(ModBlocks.SETTLED_END_STONE.asItem());
            itemGroup.add(ModBlocks.LAYERED_END_STONE.asItem());
            itemGroup.add(ModBlocks.LAYERED_VOID_SHALE.asItem());
            itemGroup.add(ModBlocks.VOID_SHALE.asItem());
            itemGroup.add(ModBlocks.TEKTITE_PILLAR.asItem());
        });
        ItemGroupEvents.modifyEntriesEvent(ModItems.SQUEEZED_ITEMGROUP_MAIN_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.TEKTITE_PILLAR.asItem());
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
    public static final Block SETTLED_END_STONE = register(
            "settled_end_stone",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(3,9).sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block LAYERED_END_STONE = register(
            "layered_end_stone",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(2.25f,9).sounds(BlockSoundGroup.STONE),
            true
    );
    public static final Block LAYERED_VOID_SHALE = register(
            "layered_void_shale",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(2.25f,9).sounds(BlockSoundGroup.DEEPSLATE),
            true
    );
    public static final Block VOID_SHALE = register(
            "void_shale",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(1.5f,9).sounds(BlockSoundGroup.DEEPSLATE),
            true
    );
    public static final Block TEKTITE_PILLAR = register(
            "tektite_pillar",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(1,15).sounds(BlockSoundGroup.BASALT),
            true
    );
}