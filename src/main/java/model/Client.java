package model;

import service.MonitorService;
import service.WriterService;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private MonitorService monitor;
    private WriterService writer;

    public Client(String inboxDir, String outboxDir) {
        this.monitor = new MonitorService(inboxDir);
        this.writer = new WriterService(outboxDir);
    }

    public void start() throws IOException {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.execute(this.monitor);
        this.monitor.run();
    }

    public void sendMessage(Message message) throws IOException {
        this.writer.write(message);
    }

    @Override
    public String toString() {
        return "Client{" +
                "monitor=" + monitor +
                ", writer=" + writer +
                '}';
    }
}
