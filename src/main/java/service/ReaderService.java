package service;

import com.google.gson.Gson;
import model.Message;

import java.io.*;

public class ReaderService {

    public ReaderService(){
    }

    public String readMessage(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader buffer = new BufferedReader(fileReader);
        String lastLine = "";
        String sCurrentLine = "";
        while ((sCurrentLine = buffer.readLine()) != null) {
            lastLine = sCurrentLine;
        }
        return lastLine;
    }

}
