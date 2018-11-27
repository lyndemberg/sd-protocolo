package service;

import com.google.gson.Gson;
import model.Message;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriterService {
    private Gson gson;

    public WriterService(Gson gson) {
        this.gson = gson;
    }

    public void write(String pathFile, Message message) throws IOException {
        File file = new File(pathFile);
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream output = new FileOutputStream(file);
        output.write(gson.toJson(message).getBytes());
        output.write("\n".getBytes());
        output.close();
    }
}
