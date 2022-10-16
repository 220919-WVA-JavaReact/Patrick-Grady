package com.revature.models;

public class OkMessage implements Message{
    private final int status;
    private final String message;
    private final Object payload;

    public OkMessage(Object payload) {
        this.status = 200;
        this.message = "OK";
        this.payload = payload;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getPayload() {
        return payload;
    }
}
