package com.alterra.redis.entities;

public class BaseBookResponse<T> {
    private String status;
    private String message;
    private T data;

    public BaseBookResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseBookResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
