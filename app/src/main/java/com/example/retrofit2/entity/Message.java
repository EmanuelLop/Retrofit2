package com.example.retrofit2.entity;

public class Message {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
