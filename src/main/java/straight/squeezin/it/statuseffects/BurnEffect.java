package straight.squeezin.it.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

// Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
// MIT License!
public class BurnEffect extends StatusEffect {
    private int pDuration;
    private LivingEntity pEntity;
    public BurnEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.getFireTicks() < this.pDuration) {
            pEntity = entity;
            entity.setFireTicks(this.pDuration);
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override public void onRemoved(AttributeContainer attributeContainer) {
        pEntity.setFireTicks(0);
        super.onRemoved(attributeContainer);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        this.pDuration = duration;
        return true;
    }
}