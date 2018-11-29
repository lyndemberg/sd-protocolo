package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import model.Message;
import model.TextMessage;
import util.JsonUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReaderService {
    private final Gson gson;

    public ReaderService(){
        this.gson = JsonUtils.getGsonWithAdapters();
    }

    public Message readMessage(File file) throws IOException {
        List<Message> messages = listAllMessages(file);
        return messages.get(messages.size() - 1);
    }

    public List<Message> listAllMessages(File file) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(file));
        Type listType = new TypeToken<ArrayList<Message>>(){}.getType();
        List<Message> messages = this.gson.fromJson(reader, listType);
        if(messages == null){
            return new ArrayList<Message>();
        }else {
            return messages;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String outbox = "/home/lyndemberg/this/chat.json";
        File file = new File(outbox);
        ReaderService rs = new ReaderService();
        for (Message m : rs.listAllMessages(file)) {
            if (m instanceof TextMessage){
                System.out.println(((TextMessage) m).toString());
            }
        }
    }


}
