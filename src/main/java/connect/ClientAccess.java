package connect;

import model.Message;
import service.MonitorService;
import service.WriterService;

import java.io.IOException;

public class ClientAccess {
    private String signature;
    private MonitorService monitor;
    private WriterService writer;

    public ClientAccess(String signature, String inboxDir, String outboxDir) {
        this.signature = signature;
        this.monitor = new MonitorService(inboxDir);
        this.writer = new WriterService(outboxDir);
    }

    public void start() throws IOException {
        Thread thread = new Thread(this.monitor);
        thread.start();
    }

    public void sendMessage(Message message) throws IOException {
        message.setSignature(this.signature);
        this.writer.write(message);
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "ClientAccess{" +
                "monitor=" + monitor +
                ", writer=" + writer +
                '}';
    }
}
