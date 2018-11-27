package model;

import service.MonitorService;
import service.WriterService;

import java.io.File;
import java.io.IOException;

public class Client {
    private String inboxDir;
    private String outboxDir;
    private MonitorService monitor;
    private WriterService writer;

    public Client(String inboxDir, String outboxDir) {
        this.inboxDir = inboxDir;
        this.outboxDir = outboxDir;
        this.monitor = new MonitorService(this.getInboxDir());
        this.writer = new WriterService(this.getOutboxDir());
    }

    public String getInboxDir() {
        return inboxDir;
    }

    public void setInboxDir(String inboxDir) {
        this.inboxDir = inboxDir;
    }

    public String getOutboxDir() {
        return outboxDir;
    }

    public void setOutboxDir(String outboxDir) {
        this.outboxDir = outboxDir;
    }

    public void start() throws IOException {
        File file = new File(this.outboxDir + "chat.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        this.monitor.run();
    }

    public void sendMessage(String message) throws IOException {
        this.writer.write(message);
    }

    @Override
    public String toString() {
        return "Client{" +
                "inboxDir='" + inboxDir + '\'' +
                ", outboxDir='" + outboxDir + '\'' +
                ", monitor=" + monitor +
                ", writer=" + writer +
                '}';
    }
}
