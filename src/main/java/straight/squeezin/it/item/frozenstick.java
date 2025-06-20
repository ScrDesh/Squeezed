package straight.squeezin.it.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import straight.squeezin.it.statuseffects.ModEffects;
import net.minecraft.block.Blocks;


public class frozenstick extends Item {

    public frozenstick(Settings settings) {
        super(settings.maxDamage(50));
    }
    @Override public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getItemCooldownManager().isCoolingDown(stack)) {
            return ActionResult.FAIL;
        }
        if (!user.getWorld().isClient) {

            StatusEffectInstance freezeEffectInstance = new StatusEffectInstance(
                    ModEffects.FREEZE,
                    300,
                    1
            );

            entity.addStatusEffect(freezeEffectInstance);
            entity.setFrozenTicks(150);

            EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            stack.damage(5, user, slot);

            user.getItemCooldownManager().set(stack, 60);
        }
        return ActionResult.SUCCESS;
    }

    @Override public ActionResult use(World world, PlayerEntity user, Hand hand) {

        BlockHitResult fluid = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        BlockPos waterLoc = fluid.getBlockPos();

        if (world.getBlockState(waterLoc).getBlock() == Blocks.WATER || world.getBlockState(waterLoc).getBlock() == Blocks.LAVA) {
            if (world.getBlockState(waterLoc).getBlock() == Blocks.WATER) {world.setBlockState(waterLoc, Blocks.ICE.getDefaultState());}
            else {world.setBlockState(waterLoc, Blocks.OBSIDIAN.getDefaultState());}


            ItemStack stack = user.getStackInHand(hand);

            EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            stack.damage(1, user, slot);

            user.getItemCooldownManager().set(stack, 10);

            return ActionResult.SUCCESS;
        }
        else {return ActionResult.FAIL;}
    }

}