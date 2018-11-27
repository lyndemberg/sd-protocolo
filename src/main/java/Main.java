import service.MonitorService;

import java.io.*;
import com.sun.istack.internal.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        String dir = "/home/lyndemberg/node1-share/";
        String file = "chat.json";
        MonitorService monitor = new MonitorService(dir, file);
        monitor.run();

    }
}
