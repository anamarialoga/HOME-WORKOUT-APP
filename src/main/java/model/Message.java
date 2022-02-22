package model;

import java.security.NoSuchAlgorithmException;

public class Message {

    private String message;
    public Message() {}

    public Message(String message){
        this.message=message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass())
            return false;

        Message client=(Message) o;

        if(!message.equals(client.message))
            return false;


        return true;
    }
    @Override
    public String toString() {
        return "Message -> " + message;
    }
}