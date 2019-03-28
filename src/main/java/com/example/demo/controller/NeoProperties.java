package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
@Component
public class NeoProperties {
    @Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        hellTask();
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String hellTask() {
        System.out.println("userName:" + title);
        System.out.println("password:" + description);
        return "hello task !!";
    }
}
