package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReceiveMessage extends Message{

    private String idTextMessage;

    public ReceiveMessage(String signature, String idTextMessage) {
        super(signature, "Receive");
        this.idTextMessage = idTextMessage;
    }

    public String getIdTextMessage() {
        return idTextMessage;
    }

    public void setIdTextMessage(String idTextMessage) {
        this.idTextMessage = idTextMessage;
    }

    @Override
    public String toString() {
        return "ReceiveMessage{" +
                "signature='" + getSignature() + '\'' +
                ", stamp=" + getStamp() +
                ", typeMessage='" + getTypeMessage() + '\'' +
                ", idTextMessage='" + idTextMessage + '\'' +
                '}';
    }
}
