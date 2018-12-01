package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReceiveMessage extends Message{

    private String stampTextMessage;

    public ReceiveMessage(String stampTextMessage) {
        super("Receive");
        this.stampTextMessage = stampTextMessage;
    }


    public String getStampTextMessage() {
        return stampTextMessage;
    }

    public void setStampTextMessage(String stampTextMessage) {
        this.stampTextMessage = stampTextMessage;
    }

    @Override
    public String toString() {
        return "ReceiveMessage{" +
                "signature='" + getSignature() + '\'' +
                ", stamp=" + getStamp() +
                ", typeMessage='" + getTypeMessage() + '\'' +
                ", stampTextMessage='" + stampTextMessage + '\'' +
                '}';
    }
}
