package net.hamakakki13.forgekebab.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class AseistettuKebab extends SwordItem{


    public AseistettuKebab(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200), pAttacker);
        pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200), pAttacker);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 3));
        ItemStack st = pStack.copy();
        st.hurtAndBreak(500, pLivingEntity, p -> p.broadcastBreakEvent(InteractionHand.MAIN_HAND));
        pLivingEntity.eat(pLevel, pStack);

        return st;
    }

   // @Override
   // public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
    //    pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 3));
    //    if (this.isEdible()) {
     //       ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
     //       ItemStack stack = pPlayer.getUseItem();
    //        if (pPlayer.canEat(this.getFoodProperties().canAlwaysEat())) {
     //           pPlayer.startUsingItem(pUsedHand);
    //            return InteractionResultHolder.fail(stack);
//
  //          }
   //     }
   //     return super.use(pLevel, pPlayer, pUsedHand);
   // }


}
