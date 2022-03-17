package com.danicadale.stateoftheunion;

/**
 * A container of information about a state
 *
 * @author Danica Dale
 * @since January 2022
 */
public class StateInfo {


    private String name;
    private String abbr;
    private String capitol;
    private String flower;
    private String bird;
    private int year;



    public StateInfo() {

    }



    public StateInfo(String name,
                     String abbr,
                     String capitol,
                     String flower,
                     String bird,
                     int year) {

        this.name = name;
        this.abbr = abbr;
        this.capitol = capitol;
        this.flower = flower;
        this.bird = bird;
        this.year = year;
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
        System.out.println("Burb: " + bird);
        System.out.println("Year: " + year);
    }


    /*
     * IntelliJ and code smell sniffers will complain that these setters and getters aren't needed.
     * However, they are actually used via reflection by Jackson when deserializing JSON responses
     * from the remote Atlas microservice.
     */

    public void setName(String name) {

        this.name = name;
    }



    public void setAbbr(String abbr) {

        this.abbr = abbr;
    }



    public void setCapitol(String capitol) {

        this.capitol = capitol;
    }



    public void setFlower(String flower) {

        this.flower = flower;
    }



    public void setBird(String bird) {

        this.bird = bird;
    }



    public void setYear(int year) {

        this.year = year;
    }



    public String getName() {

        return name;
    }



    public String getAbbr() {

        return abbr;
    }



    public String getCapitol() {

        return capitol;
    }



    public String getFlower() {

        return flower;
    }



    public String getBird() {

        return bird;
    }



    public int getYear() {

        return year;
    }
}
