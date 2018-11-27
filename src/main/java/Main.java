import model.Client;
import model.TextMessage;
import service.MonitorService;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.istack.internal.logging.Logger;
import service.WriterService;

public class Main {
    public static void main(String[] args) throws IOException {
        String inbox = args[0];
        String outbox = args[1];
        Client client = new Client(inbox, outbox);
        System.out.println(client.toString());
        TextMessage textMessage = new TextMessage("aBA120", "E aí bicho");
        client.sendMessage(textMessage);
        client.start();






    }
}
