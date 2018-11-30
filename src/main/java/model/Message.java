package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

public abstract class Message implements Serializable {

    private String signature;
    private Timestamp stamp;
    private String typeMessage;

    public Message(String typeMessage) {
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

    public String getTypeMessage() {
        return typeMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (signature != null ? !signature.equals(message.signature) : message.signature != null) return false;
        if (stamp != null ? !stamp.equals(message.stamp) : message.stamp != null) return false;
        return typeMessage != null ? typeMessage.equals(message.typeMessage) : message.typeMessage == null;
    }

    @Override
    public int hashCode() {
        int result = signature != null ? signature.hashCode() : 0;
        result = 31 * result + (stamp != null ? stamp.hashCode() : 0);
        result = 31 * result + (typeMessage != null ? typeMessage.hashCode() : 0);
        return result;
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
