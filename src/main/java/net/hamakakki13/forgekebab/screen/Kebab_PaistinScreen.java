package net.hamakakki13.forgekebab.screen;


import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.hamakakki13.forgekebab.ForgeKebab;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class Kebab_PaistinScreen extends AbstractContainerScreen<Kebab_PaistinMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ForgeKebab.MOD_ID, "textures/gui/kebab_paistin_gui.png");

    public Kebab_PaistinScreen(Kebab_PaistinMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTicks, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        if(menu.isCrafting()) {
            blit(pPoseStack, x + 81, y + 42, 178, 21, menu.getScaledProgress(), 36);
        }

        if(menu.hasFuel()) {
            blit(pPoseStack, x + 10, y + 44 + 1 - menu.getScaledFuelProgress(), 177,
                    1 - menu.getScaledFuelProgress(), 1, menu.getScaledFuelProgress());
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}