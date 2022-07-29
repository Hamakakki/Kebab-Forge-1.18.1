package net.hamakakki13.forgekebab.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hamakakki13.forgekebab.ForgeKebab;
import net.hamakakki13.forgekebab.entity.custom.Kebab_ElainEntity;
import net.hamakakki13.forgekebab.entity.variant.Kebab_ElainVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class Kebab_ElainRenderer extends GeoEntityRenderer<Kebab_ElainEntity> {

    public static final Map<Kebab_ElainVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(Kebab_ElainVariant.class), (p_114874_) -> {
                p_114874_.put(Kebab_ElainVariant.DEFAULT,
                        new ResourceLocation(ForgeKebab.MOD_ID, "textures/entity/kebab_elain/kebab_elain.png"));
                p_114874_.put(Kebab_ElainVariant.VAUVA,
                        new ResourceLocation(ForgeKebab.MOD_ID, "textures/entity/kebab_elain/kebab_elain.png"));
            });



    public Kebab_ElainRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Kebab_ElainModel());
        this.shadowRadius = 1f;
    }

    @Override
    public ResourceLocation getTextureLocation(Kebab_ElainEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(Kebab_ElainEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder,
                                    int packedLightIn, ResourceLocation textureLocation) {
        if (animatable.isBaby()) {
            stack.scale(0.3F, 0.3F, 0.3F);
        }
        else {
            stack.scale(0.6F, 0.6F, 0.6F);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
