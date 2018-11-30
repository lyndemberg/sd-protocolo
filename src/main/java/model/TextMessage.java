package model;

import java.sql.Timestamp;

public class TextMessage extends Message{

    private String body;

    public TextMessage(String body) {
        super("Text");
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "signature='" + getSignature() + '\'' +
                ", stamp=" + getStamp() +
                ", typeMessage='" + getTypeMessage() + '\'' +
                ", body='" + body  + '\'' +
                '}';
    }
}
