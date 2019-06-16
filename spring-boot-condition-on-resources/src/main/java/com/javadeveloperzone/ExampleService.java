package com.javadeveloperzone;

public class ExampleService {
    private String json;

    ExampleService(String json){
        this.json= json;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
