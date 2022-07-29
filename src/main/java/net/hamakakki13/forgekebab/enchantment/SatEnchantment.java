package net.hamakakki13.forgekebab.enchantment;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SatEnchantment extends Enchantment {
    protected SatEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostHurt(LivingEntity pUser, Entity pAttacker, int pLevel) {
        if(pLevel == 1) {
            pUser.addEffect(new MobEffectInstance(MobEffects.SATURATION, 20, 1));
        }
        if(pLevel == 2) {
            pUser.addEffect(new MobEffectInstance(MobEffects.SATURATION, 40, 1));
        }
        if(pLevel == 3) {
            pUser.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 1));
        }
        if(pLevel == 4) {
            pUser.addEffect(new MobEffectInstance(MobEffects.SATURATION, 20, 2));
        }
        if(pLevel == 5) {
            pUser.addEffect(new MobEffectInstance(MobEffects.SATURATION, 40, 2));
        }
        if(pLevel == 6) {
            pUser.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 2));
        }
        if(pLevel == 7) {
            pUser.addEffect(new MobEffectInstance(MobEffects.SATURATION, 20, 3));
        }
        if(pLevel == 8) {
            pUser.addEffect(new MobEffectInstance(MobEffects.SATURATION, 40, 3));
        }
        if(pLevel == 9) {
            pUser.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 3));
        }
        if(pLevel == 10) {
            pUser.addEffect(new MobEffectInstance(MobEffects.SATURATION, 100, 4));
        }
        super.doPostHurt(pUser, pAttacker, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 10;
    }
}
