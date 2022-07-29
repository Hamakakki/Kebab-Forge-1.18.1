package net.hamakakki13.forgekebab.entity.client;

import net.hamakakki13.forgekebab.ForgeKebab;
import net.hamakakki13.forgekebab.entity.custom.Kebab_ElainEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Kebab_ElainModel extends AnimatedGeoModel<Kebab_ElainEntity> {
    @Override
    public void setLivingAnimations(Kebab_ElainEntity entity, Integer uniqueID, AnimationEvent customPredicate) {

    }

    @Override
    public ResourceLocation getModelLocation(Kebab_ElainEntity object) {
        return new ResourceLocation(ForgeKebab.MOD_ID, "geo/kebab_elain.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Kebab_ElainEntity object) {
        return Kebab_ElainRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Kebab_ElainEntity animatable) {
        return new ResourceLocation(ForgeKebab.MOD_ID, "geo/kebab_elain.geo.json");
    }
}
