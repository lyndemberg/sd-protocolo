package model;

import java.sql.Timestamp;

public abstract class Message {
    private Timestamp stamp;
    private String signature;

    public Message(String signature, Timestamp stamp){
        this.signature = signature;
    }

    public Timestamp getStamp() {
        return stamp;
    }

    public void setStamp(Timestamp stamp) {
        this.stamp = stamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (stamp != null ? !stamp.equals(message.stamp) : message.stamp != null) return false;
        return signature != null ? signature.equals(message.signature) : message.signature == null;
    }

    @Override
    public int hashCode() {
        int result = stamp != null ? stamp.hashCode() : 0;
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        return result;
    }

    public abstract String show();
}
