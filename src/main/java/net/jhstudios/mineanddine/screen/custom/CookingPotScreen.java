package net.jhstudios.mineanddine.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.jhstudios.mineanddine.MineAndDine;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CookingPotScreen extends HandledScreen<CookingPotScreenHandler> {
    public static final Identifier GUI_TEXTURE = Identifier.of(MineAndDine.MOD_ID, "textures/gui/cooking_pot/cooking_pot_gui.png");

    public CookingPotScreen(CookingPotScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f,1f,1f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

    }
}
