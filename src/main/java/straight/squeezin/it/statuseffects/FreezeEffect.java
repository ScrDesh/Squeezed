package straight.squeezin.it.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class FreezeEffect extends StatusEffect {
    public FreezeEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.getFrozenTicks() < 145) {entity.setFrozenTicks(entity.getFrozenTicks()+5);}

        return super.applyUpdateEffect(world, entity, amplifier);
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}