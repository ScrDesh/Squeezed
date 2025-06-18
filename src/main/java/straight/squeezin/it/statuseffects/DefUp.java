package straight.squeezin.it.statuseffects;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;

public class DefUp extends StatusEffect {
    public DefUp(StatusEffectCategory category, int color) {
        super(category, color);

        this.addAttributeModifier(
                EntityAttributes.ARMOR, Identifier.of("squeezed", "armor-up"),
                3,
                EntityAttributeModifier.Operation.ADD_VALUE
        );

        this.addAttributeModifier(
                EntityAttributes.ARMOR, Identifier.of("squeezed", "armortough-up"),
                2,
                EntityAttributeModifier.Operation.ADD_VALUE
        );
    }
}