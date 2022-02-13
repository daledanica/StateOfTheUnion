package com.danicadale.stateoftheunion;

public class Choice {

    private final String selector;
    private final String description;



    public Choice(String selector, String description) {

        this.selector = selector;
        this.description = description;
    }



    public String getSelector() {

        return selector;
    }



    public String getDescription() {

        return description;
    }
}
