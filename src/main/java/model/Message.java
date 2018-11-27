package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

public abstract class Message implements Serializable {

    private String signature;
    private Timestamp stamp;

    public Message(String signature) {
        this.signature = signature;
        this.stamp = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public abstract String show();

    public abstract String typeMessage();

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
}
