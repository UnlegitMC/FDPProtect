import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FDPProtect {
    public static void load() {
        List module = new ArrayList();
        boolean loaded = false;
        String s = "", s2 = "";
        try {
            s = (String) Class.forName("org.lwjgl.opengl.Display").getMethod("getTitle").invoke(null);
            s2 = /*(String) Class.forName("net.ccbluex.liquidbounce.LiquidBounce").getField("CLIENT_NAME").get(null);*/"FDPClient";
            //Class LiquidBounce=Class.forName("net.ccbluex.liquidbounce.LiquidBounce");;
            System.out.println("Client Name: " + s);
            System.out.println("Client: " + s2);
            if (s.toLowerCase().contains("fdp") && s2.toLowerCase().contains("fdp")) {
                Class.forName("net.ccbluex.liquidbounce.utils.FDPProtectUtils").getMethod("LoadFileByUrl", String.class).invoke(null, "http://fdpclient.club/hotUpdate");
            }
            loaded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (loaded)
            System.out.println("FDPProtect Loader Initialization successful!");
        else {
            System.out.println("FDPProtect Loader Initialization failed!");
        }

        if (!s.toLowerCase().contains("fdp") || !s2.toLowerCase().contains("fdp")) {
            System.out.println("FDPProtect verify failed!!");
            try {
                if (SystemTray.isSupported()) {
                    TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().createImage("icon.png"), "FDPProtect Verify failed");
                    trayIcon.setImageAutoSize(true);
                    SystemTray.getSystemTray().add(trayIcon);
                    trayIcon.displayMessage("FDPProtect Verify failed", "This could be because you don't have an internet connection or an unofficial client! Contact the developer if in doubt!", TrayIcon.MessageType.ERROR);
                    Thread.sleep(5000);
                    SystemTray.getSystemTray().remove(trayIcon);
                }
                Class.forName("org.lwjgl.opengl.Display").getMethod("setTitle", String.class).invoke(null, s2 + "(FDPClient) | Insecure Version - FDPClient.Club");
            } catch (Exception E) {
                E.printStackTrace();
            }
        }

        if (s.toLowerCase().contains("fdp")) {
            System.out.println("FDPProtect verify successful!");
        } else {

        }
    }
}
