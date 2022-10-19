package com.revature.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendInfo {
    private final int status;
    private final String message;
    private String sendType = "String";


    public SendInfo(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public SendInfo(int status, Object message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        this.status = status;
        this.message = mapper.writeValueAsString(message);
        this.sendType = "Object";
    }

    public void send(HttpServletResponse res) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        res.setStatus(this.status);
        String contentType = "application/json";
        res.setContentType(contentType);
        if (this.sendType.equals("String")) {
            res.getWriter().write(mapper.writeValueAsString(this.message));
        } else {
            res.getWriter().write(this.message);
        }

    }
}
