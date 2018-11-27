package model;

import java.sql.Timestamp;

public class TextMessage extends Message{

    private String body;

    public TextMessage(String signature, String body) {
        super(signature);
        this.body = body;
    }


    @Override
    public String show() {
        return null;
    }

    @Override
    public String typeMessage() {
        return "Text";
    }

}
