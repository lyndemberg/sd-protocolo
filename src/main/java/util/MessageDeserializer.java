package util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import model.Message;
import model.ReceiveMessage;
import model.TextMessage;

import java.lang.reflect.Type;

public class MessageDeserializer implements JsonDeserializer<Message> {

    @Override
    public Message deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        String typeMessage = jsonElement.getAsJsonObject().get("typeMessage").getAsString();
        switch(typeMessage) {
            case "Receive":
                return context.deserialize(jsonElement, ReceiveMessage.class);
            case "Text":
                return context.deserialize(jsonElement, TextMessage.class);
            default:
                throw new IllegalArgumentException("Neither Receive or Text");
        }
    }
}
