package model;

import java.sql.Timestamp;

public class TextMessage extends Message{

    private String body;

    public TextMessage(String signature, Timestamp stamp) {
        super(signature, stamp);
    }

    @Override
    public String show() {
        return "De: " + super.getSignature() + "\n" +
        " Mensagem: " + body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
