package model;

import java.sql.Timestamp;

public class ReceiveMessage extends Message{
    private String idTextMessage;

    public ReceiveMessage(String signature, Timestamp stamp) {
        super(signature, stamp);
    }

    @Override
    public String show() {
        return "A mensagem " + idTextMessage + " foi entregue";
    }

    public String getIdTextMessage() {
        return idTextMessage;
    }

    public void setIdTextMessage(String idTextMessage) {
        this.idTextMessage = idTextMessage;
    }
}
