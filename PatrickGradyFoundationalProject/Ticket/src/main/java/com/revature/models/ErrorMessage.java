package com.revature.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorMessage that = (ErrorMessage) o;
        return status == that.status && Objects.equals(message, that.message) && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, payload);
    }
}
