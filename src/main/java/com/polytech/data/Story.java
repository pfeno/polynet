package com.polytech.data;

public class Story {
    String content;


    public Story(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Story{" +
                "content='" + content + '\'' +
                '}';
    }
}
