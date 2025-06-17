package straight.squeezin.it.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;


public class firestick extends Item {

    public firestick(Settings settings) {
        super(settings.maxDamage(10));
    }
    @Override public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getItemCooldownManager().isCoolingDown(stack)) {
            return ActionResult.FAIL;
        }
        if (!user.getWorld().isClient) {
            entity.setFireTicks(100); // Set entity on fire for 5 seconds (5 * 20 ticks)

            EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            stack.damage(1, user, slot);

            user.getItemCooldownManager().set(stack, 20);
        }
        return ActionResult.SUCCESS;
    }
}