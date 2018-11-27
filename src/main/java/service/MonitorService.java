package service;

import com.sun.nio.file.SensitivityWatchEventModifier;
import model.Message;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class MonitorService extends Thread{
    private final String dir;
    private final String file;
    private final Path path;
    private final ReaderService readerService;
    private Message lastMessage;
    
    public MonitorService(String dir, String file){
        this.dir = dir;
        this.file = file;
        this.path = Paths.get(dir + file);
        readerService = new ReaderService();
    }

    @Override
    public void run() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey key = watchService.take();
            while(true){
                for(WatchEvent<?> event : key.pollEvents()){
//                    WatchEvent.Kind<?> eventKind = event.kind();
                    String eventName = event.context().toString();
                    if(eventName.equals(this.file)){
                        System.out.println(this.file + " FOI MODIFICADO");
                        Message message = readerService.readMessage(dir + file);
                        if(!message.equals(this.lastMessage)){
                            System.out.println(message.show());
                            this.lastMessage = message;
                        }
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
}
