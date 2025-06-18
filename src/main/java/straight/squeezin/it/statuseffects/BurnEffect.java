package straight.squeezin.it.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;

import static java.lang.Math.max;

public class BurnEffect extends StatusEffect {
    public BurnEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (!(entity.isSubmergedInWater()) &&
                !(world.isRaining() && world.isSkyVisible(entity.getBlockPos()))) {
            entity.damage(world, world.getDamageSources().onFire(), 1.0f + amplifier);
            spawnFlameParticles(world, entity, (max(amplifier*6, 18)));
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    private void spawnFlameParticles(ServerWorld world, LivingEntity entity, int amplifier) {
        Random random = world.getRandom();

        // Get entity bounding box
        Box boundingBox = entity.getBoundingBox();
        double width = boundingBox.getLengthX();
        double height = boundingBox.getLengthY();
        double depth = boundingBox.getLengthZ();

        // More particles for higher amplifier
        int particleCount = 1 + amplifier;

        for (int i = 0; i < particleCount; i++) {
            // Random position within bounding box
            double offsetX = (random.nextDouble() - 0.5) * width * 0.8; // 80% of width
            double offsetY = random.nextDouble() * height * 0.9; // 90% of height
            double offsetZ = (random.nextDouble() - 0.5) * depth * 0.8; // 80% of depth

            double x = entity.getX() + offsetX;
            double y = entity.getY() + offsetY;
            double z = entity.getZ() + offsetZ;

            // Upward-biased velocity (like fire rises)
            double velocityX = (random.nextDouble() - 0.5) * 0.05;
            double velocityY = random.nextDouble() * 0.1 + 0.02; // Always upward
            double velocityZ = (random.nextDouble() - 0.5) * 0.05;

            // Mix of flame and smoke particles
            if (random.nextBoolean()) {
                world.spawnParticles(ParticleTypes.FLAME, x, y, z, 1, velocityX, velocityY, velocityZ, 0.01);
            } else {
                world.spawnParticles(ParticleTypes.SMOKE, x, y, z, 1, velocityX, velocityY, velocityZ, 0.01);
            }
        }
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}