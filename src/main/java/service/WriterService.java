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
    private final String FILE_CHAT = "chat.txt";
    private final String dir;

    public WriterService(String dir) {
        this.dir = dir;
    }

    public void write(String message) throws IOException {
        File file = new File(this.dir + FILE_CHAT);
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream output = new FileOutputStream(file);
        output.write(message.getBytes());
        output.write("\n".getBytes());
        output.close();
    }
}
