import model.Client;
import model.TextMessage;
import service.MonitorService;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

import com.sun.istack.internal.logging.Logger;
import service.WriterService;

public class Main {
    public static void main(String[] args) throws IOException {
        String inbox = args[0];
        String outbox = args[1];
        Client client = new Client(inbox, outbox);
        System.out.println(client.toString());
        client.sendMessage("e ai jozimar");
        client.start();





    }
}
