package com.alterra.websocket.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty
    private String from;

    @JsonProperty
    private String text;

    public Message(String from, String text) {
        this.from = from;
        this.text = text;
    }

    public Message() {

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
