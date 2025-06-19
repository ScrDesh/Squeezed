package straight.squeezin.it.world.tree;

import net.minecraft.block.SaplingGenerator;
import straight.squeezin.it.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator BLIGHTED = new SaplingGenerator("squeezed:blighted",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLIGHTED_KEY), Optional.empty());
}
