package com.revature.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendInfo {
    private final int status;
    private String contentType;
    private final String message;

    public SendInfo(int status, String contentType, String message) {
        this.status = status;
        this.contentType = contentType;
        this.message = message;
    }

    public SendInfo(int status, String message) {
        this.status = status;
        this.contentType = contentType = "application/json";
        this.message = message;
    }

    public void send(HttpServletResponse res) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        res.setStatus(this.status);
        res.setContentType(this.contentType);
        res.getWriter().write(mapper.writeValueAsString(this.message));

    }
}
