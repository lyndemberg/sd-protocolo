package service;

import com.sun.nio.file.SensitivityWatchEventModifier;
import connect.ClientAccess;
import model.Message;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.List;

public class MonitorService implements Runnable{
    private final String diretorio;
    private ClientAccess client;
    private final ReaderService readerService;
    private Message lastMessage;
    
    public MonitorService(ClientAccess client, String diretorio){
        this.client = client;
        this.diretorio = diretorio;
        this.readerService = new ReaderService();
    }

    @Override
    public void run() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Paths.get(diretorio).register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            while(true){
                WatchKey key = watchService.take();
                for(WatchEvent<?> event : key.pollEvents()){
//                    WatchEvent.Kind<?> eventKind = event.kind();
                    String eventName = event.context().toString();
                    if(eventName.equals("chat.json")){
                        File file = new File(diretorio + File.separator + "chat.json");
                        Thread.sleep(100);
                        Message message = readerService.readMessage(file);
                        if(!message.equals(this.lastMessage)){
                            this.lastMessage = message;
                            client.notify(message);
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

    public String getDiretorio() {
        return diretorio;
    }
}
