package com.example.gmail;

public class ItemEmailModel {
    private int avtResource;

    public ItemEmailModel(int avtResource, String name, String content, String time) {
        this.avtResource = avtResource;
        this.name = name;
        this.content = content;
        this.time = time;
    }

    public int getAvtResource() {
        return avtResource;
    }

    public void setAvtResource(int avtResource) {
        this.avtResource = avtResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String name;
    private String content;
    private String time;


}
