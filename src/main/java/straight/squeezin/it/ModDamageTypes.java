package straight.squeezin.it;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> ICEBREAKING =
            RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
                    Identifier.of("squeezed", "icebreaking"));
}
