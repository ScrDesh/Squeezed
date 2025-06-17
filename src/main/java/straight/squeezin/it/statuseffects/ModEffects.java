package straight.squeezin.it.statuseffects;

import straight.squeezin.it.Squeezed;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> BURN = registerStatusEffect("burn",
            new BurnEffect(StatusEffectCategory.NEUTRAL, 0x36ebab));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Squeezed.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {}
}