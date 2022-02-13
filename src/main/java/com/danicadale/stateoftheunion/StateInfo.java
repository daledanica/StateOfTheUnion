package com.danicadale.stateoftheunion;

public class StateInfo {

    private final String name;
    private final String abbr;
    private final String capitol;
    private final String flower;
    private final String birb;
    private final String funFact;
    private final String history;



    public StateInfo(String name,
                     String abbr,
                     String capitol,
                     String flower,
                     String birb,
                     String funFact,
                     String history) {

        this.name = name;
        this.abbr = abbr;
        this.capitol = capitol;
        this.flower = flower;
        this.birb = birb;
        this.funFact = funFact;
        this.history = history;
    }



    public void print() {

        System.out.println();
        System.out.println("You chose the state: " + name);
        System.out.println();
        System.out.println("Basic state facts:");
        System.out.println("Name: " + name);
        System.out.println("Abbreviation: " + abbr);
        System.out.println("Capitol: " + capitol);
        System.out.println("Flower: " + flower);
        System.out.println("Burb: " + birb);
    }



    public void printFunFact() {

        System.out.println();
        System.out.println("Awesome! Fun fact it is :)");
        System.out.println();
        System.out.println(funFact);
    }



    public void printHistoryFact() {

        System.out.println();
        System.out.println("Awesome! History fact it is :)");
        System.out.println();
        System.out.println(history);
    }



    public String getName() {

        return name;
    }



    public String getAbbr() {

        return abbr;
    }
}
