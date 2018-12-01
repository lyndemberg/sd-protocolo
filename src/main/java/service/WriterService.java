package service;

import com.google.gson.Gson;
import model.Message;
import util.JsonUtils;

import java.io.*;
import java.util.List;

public class WriterService {
    private final Gson gson;
    private final String diretorio;

    public WriterService(String dir) {
        this.diretorio = dir;
        this.gson = JsonUtils.getGsonWithAdapters();
    }

    public void write(Message nova) throws IOException {
        File file = new File(diretorio + File.separator + "chat.json");
        List<Message> messages = new ReaderService().listAllMessages(file);
        messages.add(nova);
        try (Writer writer = new FileWriter(file)) {
            Gson gson = this.gson;
            gson.toJson(messages, writer);
            writer.close();
        }

    }

    public String getDiretorio() {
        return diretorio;
    }
}
