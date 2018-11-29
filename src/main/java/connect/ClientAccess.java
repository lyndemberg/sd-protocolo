package connect;

import model.Message;
import service.MonitorService;
import service.WriterService;

import java.io.IOException;

public class ClientAccess {
    private MonitorService monitor;
    private WriterService writer;

    public ClientAccess(String inboxDir, String outboxDir) {
        this.monitor = new MonitorService(inboxDir);
        this.writer = new WriterService(outboxDir);
    }

    public void start() throws IOException {
        Thread thread = new Thread(this.monitor);
        thread.start();
    }

    public void sendMessage(Message message) throws IOException {
        this.writer.write(message);
    }

    @Override
    public String toString() {
        return "ClientAccess{" +
                "monitor=" + monitor +
                ", writer=" + writer +
                '}';
    }
}
