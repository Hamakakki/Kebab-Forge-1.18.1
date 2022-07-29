package net.hamakakki13.forgekebab.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class PakoEnchantment  extends Enchantment {
    protected PakoEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        pAttacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 20));
        if(!pAttacker.level.isClientSide()) {
            ServerLevel world = ((ServerLevel) pAttacker.level);
            ServerPlayer player = ((ServerPlayer) pAttacker);
            BlockPos position = pTarget.blockPosition();

            EntityType.CHICKEN.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
            ((ServerPlayer) pAttacker).disconnect();

        }
        super.doPostHurt(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}

