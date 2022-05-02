import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FDPProtect {
    public static void load() {
        String s=Display.getTitle();
        if (loaded)
            System.out.println("FDPProtect Loader Initialization successful!");
        else {
            System.out.println("FDPProtect Loader Initialization failed!");
        }

        if (!s.toLowerCase().contains("fdp")) {
            System.out.println("FDPProtect verify failed!!");
        }

        if (s.toLowerCase().contains("fdp")) {
            System.out.println("FDPProtect verify successful!");
        } else {

        }
    }
}
