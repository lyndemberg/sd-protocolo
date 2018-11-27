package model;

import service.MonitorService;
import service.WriterService;

import java.io.File;
import java.io.IOException;

public class Client {

    private MonitorService monitor;
    private WriterService writer;

    public Client(String inboxDir, String outboxDir) {
        this.monitor = new MonitorService(inboxDir);
        this.writer = new WriterService(outboxDir);
    }

    public void start() throws IOException {
        File file = new File(this.monitor.getDir() + "chat.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        File file2 = new File(this.writer.getDir() + "chat.txt");
        if(!file2.exists()){
            file2.createNewFile();
        }
        this.monitor.run();
    }

    public void sendMessage(String message) throws IOException {
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
