package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import model.Message;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonUtils {

    public static Gson getGsonWithAdapters(){
        return new GsonBuilder().registerTypeAdapter(Message.class, new MessageDeserializer()).create();
    }


}

