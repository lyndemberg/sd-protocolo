import connect.ClientAccess;
import model.TextMessage;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String inbox = "/home/lyndemberg/this";
        String outbox = "/home/lyndemberg/node2";
        ClientAccess client = new ClientAccess(inbox, outbox);
        TextMessage textMessage = new TextMessage("aBA120", "E aí truta");
        client.start();
        client.sendMessage(textMessage);

    }
}
