package com.revature.models;

public interface Message {
    int status = 0;
    String message = "";
    Object payload = null;

    int getStatus();
    String getMessage();
    Object getPayload();
}
