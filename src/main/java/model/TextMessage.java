package model;

import java.sql.Timestamp;

public class TextMessage extends Message{

    private String body;

    public TextMessage(String signature, String body) {
        super(signature,"Text");
        this.body = body;
    }

    public TextMessage(){
        super("", "");
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
