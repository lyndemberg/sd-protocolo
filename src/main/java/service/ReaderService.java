package service;

import com.google.gson.Gson;
import model.Message;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderService {

    public Message readMessage(String file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(fileReader);
        String lastLine = "";
        String sCurrentLine = "";
        while ((sCurrentLine = buffer.readLine()) != null) {
            System.out.println(sCurrentLine);
            lastLine = sCurrentLine;
        }
        Message message = new Gson().fromJson(lastLine, Message.class);
        return message;
    }

}
