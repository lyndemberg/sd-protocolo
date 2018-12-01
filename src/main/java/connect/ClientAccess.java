package connect;

import model.Message;
import model.ReceiveMessage;
import service.MonitorService;
import service.WriterService;

import java.io.IOException;

public class ClientAccess {
    private final String signature;
    private final String inboxDir;
    private final String outboxDir;
    private Thread threadMonitor;
    private WriterService writer;

    public ClientAccess(String signature, String inboxDir, String outboxDir) {
        this.signature = signature;
        this.inboxDir = inboxDir;
        this.outboxDir = outboxDir;
    }

    public void start() throws IOException {
        this.threadMonitor = new Thread(new MonitorService(this, inboxDir));
        this.threadMonitor.start();
        this.writer = new WriterService(outboxDir);
    }

    public void sendMessage(Message message) throws IOException {
        message.setSignature(this.signature);
        this.writer.write(message);
    }

    public void notify(Message message) throws IOException {
        System.out.println("Nova mensagem: " + message);
        if(message.getTypeMessage().equals("Text")){
            ReceiveMessage receiveMessage = new ReceiveMessage(message.getStamp().toString());
            sendMessage(receiveMessage);
        }
    }

    public String getSignature() {
        return signature;
    }


}
