package straight.squeezin.it.item;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Optional;


public class firestick extends Item {

    public firestick(Settings settings) {
        super(settings.maxDamage(10));
    }
    @Override public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getItemCooldownManager().isCoolingDown(stack)) {
            return ActionResult.FAIL;
        }
        if (!user.getWorld().isClient) {
            entity.setFireTicks(100); // Set entity on fire for 5 seconds

            EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            stack.damage(1, user, slot);

            user.getItemCooldownManager().set(stack, 20);
        }
        return ActionResult.SUCCESS;
    }

    @Override public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity eventPlayer = context.getPlayer();
        World world = context.getWorld();
        BlockPos loc = context.getBlockPos();
        RegistryWrapper.WrapperLookup registryLookup = world.getRegistryManager();

        if (world.getBlockEntity(loc) == null) {return ActionResult.FAIL;}
        NbtCompound nbtandshi = world.getBlockEntity(loc).createNbt(registryLookup);
        Optional<Integer> burnTicksO = nbtandshi.getInt("lit_time_remaining");

        if (burnTicksO.isEmpty()) {return ActionResult.FAIL;}
        int burnTicks = burnTicksO.get();
        // Gets context ^^^^

        // Fail Conditions, no player or if item is on cooldown
        if (eventPlayer == null) {return ActionResult.FAIL;}
        if (context.getPlayer().getItemCooldownManager().isCoolingDown(context.getStack())) {return ActionResult.FAIL;}

        if (!world.isClient()) {
            int newBurnTicks = burnTicks + 200;
            nbtandshi.putInt("lit_time_remaining", newBurnTicks);
            world.getBlockEntity(loc).readComponentlessNbt(nbtandshi, registryLookup);
            world.getBlockEntity(loc).markDirty();

            // Update Blockstate
            BlockState currentState = world.getBlockState(loc);
            if (currentState.contains(AbstractFurnaceBlock.LIT)) {
                // Set the block to lit state
                BlockState litState = currentState.with(AbstractFurnaceBlock.LIT, true);
                world.setBlockState(loc, litState, 3);
            }



            // Durability Handling
            EquipmentSlot slot = context.getHand() == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            context.getStack().damage(1, context.getPlayer(), slot);

            context.getPlayer().getItemCooldownManager().set(context.getStack(), 20);
        }

        return ActionResult.SUCCESS;
        }
}