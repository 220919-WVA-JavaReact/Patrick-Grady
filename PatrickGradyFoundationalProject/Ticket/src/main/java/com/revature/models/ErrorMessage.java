package com.revature.models;

public class ErrorMessage implements Message {
    private final int status;
    private final String message;
    private final Object payload = null;

    public ErrorMessage(int status, String msg) {
        this.status = status;
        this.message = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getPayload() { return payload; }
}
