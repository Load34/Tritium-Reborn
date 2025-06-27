package me.imflowow.tritium.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.util.IChatComponent;
public class ServerUtils {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void kickFromServer(IChatComponent reason) {
        if (mc.getCurrentServerData() != null) {
            mc.theWorld.sendQuittingDisconnectingPacket();
            mc.loadWorld(null);
            mc.displayGuiScreen(new GuiDisconnected(new GuiMultiplayer(new GuiMainMenu()), "disconnect.lost", reason));
        }
    }

	public static String getServerIP() {
		return Minecraft.getMinecraft().getCurrentServerData() == null ? null
				: Minecraft.getMinecraft().getCurrentServerData().serverIP.toLowerCase();
	}

}
