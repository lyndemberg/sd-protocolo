package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import model.Message;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class WriterService {
    private final Gson gson;
    private final String FILE_CHAT = "chat.json";
    private final String dir;

    public WriterService(String dir) {
        this.dir = dir;
        this.gson = new Gson();
    }

    public void write(Message nova) throws IOException {
        File file = new File(dir + FILE_CHAT);
        List<Message> messages = new ReaderService().listAll(dir + FILE_CHAT);
        messages.add(nova);
        try (Writer writer = new FileWriter(file)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(messages, writer);
        }
    }

    @Override
    public String toString() {
        return "WriterService{" +
                "FILE_CHAT='" + FILE_CHAT + '\'' +
                ", dir='" + dir + '\'' +
                '}';
    }

    public String getDir() {
        return dir;
    }
}
