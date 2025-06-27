package tritium.netease.auth;

import java.net.Proxy;
import java.util.UUID;

import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import me.imflowow.tritium.core.Tritium;
import net.minecraft.client.Minecraft;

public class AuthUtils {


    public MinecraftSessionService bak;

    public void loadAuth(int type) {
        Minecraft mc = Minecraft.getMinecraft();
        switch (type) {
        case 0:
            mc.setSessionService(bak);
            Tritium.instance.getAuthmanager().setAuthtype(0);
            break;
        }
    }
}
