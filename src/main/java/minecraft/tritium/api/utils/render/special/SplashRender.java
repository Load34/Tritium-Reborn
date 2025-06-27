package tritium.api.utils.render.special;

import java.awt.Color;
import java.awt.Font;

import org.lwjgl.LWJGLException;

import me.imflowow.tritium.core.Tritium;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class SplashRender {

	private static Minecraft mc = Minecraft.getMinecraft();

	public static void drawSplashScreen(int much) throws LWJGLException {
		ScaledResolution sr = new ScaledResolution(mc);
		int i = sr.getScaleFactor();
		Framebuffer framebuffer = new Framebuffer(sr.getScaledWidth() * i, sr.getScaledHeight() * i, true);
		framebuffer.bindFramebuffer(false);
		GlStateManager.matrixMode(5889);
		GlStateManager.loadIdentity();
		GlStateManager.ortho(0.0D, sr.getScaledWidth(), sr.getScaledHeight(), 0.0D, 1000.0D, 3000.0D);
		GlStateManager.matrixMode(5888);
		GlStateManager.loadIdentity();
		GlStateManager.translate(0.0F, 0.0F, -2000.0F);
		GlStateManager.disableLighting();
		GlStateManager.disableFog();
		GlStateManager.disableDepth();
		GlStateManager.enableTexture2D();

		Gui.drawRect(0, 0, sr.getScaledWidth(), sr.getScaledHeight(), Color.BLACK.getRGB());

		drawImage(new ResourceLocation("tritium/icons/logo_white.png"), sr.getScaledWidth() / 2F - 32,
				sr.getScaledHeight() / 2F - 64, 64, 64);
		
		Gui.drawRect(sr.getScaledWidth() / 2 - 90, sr.getScaledHeight() - 42, sr.getScaledWidth() / 2 + 90,
				sr.getScaledHeight() - 40, Color.GRAY.getRGB());

		int width = (int) (180 * MathHelper.clamp_double(much / 100F, 0, 1));

		Gui.drawRect(sr.getScaledWidth() / 2 - 90, sr.getScaledHeight() - 42, sr.getScaledWidth() / 2 - 90 + width,
				sr.getScaledHeight() - 40, -1);

		GlStateManager.disableLighting();
		GlStateManager.disableFog();
		framebuffer.unbindFramebuffer();
		framebuffer.framebufferRender(sr.getScaledWidth() * i, sr.getScaledHeight() * i);
		GlStateManager.enableAlpha();
		GlStateManager.alphaFunc(516, 0.1F);
		mc.updateDisplay();
	}

	private static void drawImage(ResourceLocation image, double x, double y, double width, double height) {		
		GlStateManager.enableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.color(1, 1, 1);
		Minecraft.getMinecraft().getTextureManager().bindTexture(image);
		Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0, 0.0, width, height, width, height);
		GlStateManager.disableBlend();
	}
}
