package service;

import com.sun.nio.file.SensitivityWatchEventModifier;
import model.Message;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class MonitorService extends Thread{
    private final String FILE_CHAT = "chat.txt";

    private final String dir;
    private final ReaderService readerService;
    private String lastMessage;
//    private Message lastMessage;
    
    public MonitorService(String dir){
        this.dir = dir;
        readerService = new ReaderService();
    }

    @Override
    public void run() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Paths.get(dir).register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey key = watchService.take();
            while(true){
                for(WatchEvent<?> event : key.pollEvents()){
//                    WatchEvent.Kind<?> eventKind = event.kind();
                    String eventName = event.context().toString();
                    if(eventName.equals(FILE_CHAT)){
                        String message = readerService.readMessage(dir + FILE_CHAT);
                        if(!message.equals(this.lastMessage)){
                            System.out.println(message);
                            this.lastMessage = message;
                        }
//                        Message message = readerService.readMessage(dir + FILE_CHAT);

                    }
                }
                key.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MonitorService{" +
                "FILE_CHAT='" + FILE_CHAT + '\'' +
                ", dir='" + dir + '\'' +
                ", readerService=" + readerService +
                '}';
    }

    public String getDir() {
        return dir;
    }
}
