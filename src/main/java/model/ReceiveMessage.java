package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReceiveMessage extends Message{

    private String idTextMessage;

    public ReceiveMessage(String signature, String idTextMessage) {
        super(signature);
        this.idTextMessage = idTextMessage;
    }


    @Override
    public String show() {
        return "A mensagem " + idTextMessage + " foi entregue";
    }

    @Override
    public String typeMessage() {
        return "Receive";
    }


}
