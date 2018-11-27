package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import model.Message;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReaderService {
    private final Gson gson;

    public ReaderService(){
        this.gson = new Gson();
    }

    public Message readMessage(String path) throws IOException {
        JsonReader reader = new JsonReader(new FileReader(path));
        Type listType = new TypeToken<ArrayList<Message>>(){}.getType();
        List<Message> messages = new Gson().fromJson(reader,listType);
        return messages.get(messages.size() - 1);
    }

    public List<Message> listAll(String path) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(path));
        Type listType = new TypeToken<ArrayList<Message>>(){}.getType();
        List<Message> messages = new Gson().fromJson(reader,listType);
        if(messages == null){
            return new ArrayList<Message>();
        }else {
            return messages;
        }
    }

}
