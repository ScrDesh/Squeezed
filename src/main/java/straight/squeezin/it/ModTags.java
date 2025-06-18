package straight.squeezin.it;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static TagKey<Block> BLIGHTED_LOGS = createTag("blighted_logs");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Squeezed.MOD_ID, name));
        }
    }

    public static class Items {
        public static TagKey<Item> BLIGHTED_LOGS = createTag("blighted_logs");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Squeezed.MOD_ID, name));
        }
    }
}
