package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

public abstract class Message implements Serializable {

    private String signature;
    private Timestamp stamp;
    private String typeMessage;

    public Message(String signature, String typeMessage) {
        this.signature = signature;
        this.typeMessage = typeMessage;
        this.stamp = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Timestamp getStamp() {
        return stamp;
    }

    public void setStamp(Timestamp stamp) {
        this.stamp = stamp;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    @Override
    public String toString() {
        return "Message{" +
                "signature='" + signature + '\'' +
                ", stamp=" + stamp +
                ", typeMessage='" + typeMessage + '\'' +
                '}';
    }
}
