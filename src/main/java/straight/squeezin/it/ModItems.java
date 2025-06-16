package straight.squeezin.it;


import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.*;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Squeezed.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final Item FIRESTICK = ModItems.register(
            "firestick",
            firestick::new, // uses your custom item class
            new Item.Settings().maxCount(1).maxDamage(10).maxCount(1)
    );

    public static void initialize() {
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, SQUEEZED_ITEMGROUP_MAIN_KEY, SQUEEZED_ITEMGROUP_MAIN);
        Registry.register(Registries.ITEM_GROUP, SQUEEZED_ITEMGROUP_MCD_KEY, SQUEEZED_ITEMGROUP_MCD);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(SQUEEZED_ITEMGROUP_MAIN_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.FIRESTICK);
        });
    }

    public static final RegistryKey<ItemGroup> SQUEEZED_ITEMGROUP_MAIN_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Squeezed.MOD_ID, "item_group_main"));
    public static final RegistryKey<ItemGroup> SQUEEZED_ITEMGROUP_MCD_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Squeezed.MOD_ID, "item_group_mcd"));
    public static final ItemGroup SQUEEZED_ITEMGROUP_MCD = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.BLIGHTED_GRASS.asItem()))
            .displayName(Text.translatable("itemGroup.squeezed.mcdungeonrips"))
            .build();
    public static final ItemGroup SQUEEZED_ITEMGROUP_MAIN = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.BLIGHTED_GRASS.asItem()))
            .displayName(Text.translatable("itemGroup.squeezed"))
            .build();
}