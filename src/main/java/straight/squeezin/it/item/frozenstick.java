package straight.squeezin.it.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import straight.squeezin.it.statuseffects.ModEffects;


public class frozenstick extends Item {

    public frozenstick(Settings settings) {
        super(settings.maxDamage(10));
    }
    @Override public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getItemCooldownManager().isCoolingDown(stack)) {
            return ActionResult.FAIL;
        }
        if (!user.getWorld().isClient) {

            StatusEffectInstance burnEffectInstance = new StatusEffectInstance(
                    ModEffects.DEFDOWN,
                    300,
                    1
            );

            entity.addStatusEffect(burnEffectInstance);
            entity.setFrozenTicks(380);

            EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            stack.damage(1, user, slot);

            user.getItemCooldownManager().set(stack, 20);
        }
        return ActionResult.SUCCESS;
    }

}