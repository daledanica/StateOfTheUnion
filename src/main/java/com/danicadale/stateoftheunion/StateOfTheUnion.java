package com.danicadale.stateoftheunion;

import java.util.Arrays;
import java.util.Locale;



public class StateOfTheUnion {


    private static StateInfo getState(AtlasService atlasService) {

        while (true) {
            System.out.print("\nEnter state abbr (or Q to quit): ");
            String stateName = Io.readLine();
            if (stateName.isBlank()) continue;
            stateName = stateName.toUpperCase();
            if (stateName.equalsIgnoreCase("Q")) {
                confirmQuit();
                continue;
            }

            StateInfo stateInfo = atlasService.lookUp(stateName);
            if (stateInfo == null) {
                System.out.println("I'm sorry, I don't know of a state named: " + stateName);
                continue;
            }

            return stateInfo;
        }
    }



    private static void confirmQuit() {

        System.out.print("Are you sure you want to quit? [y/n]: ");
        String answer = Io.readLine();
        if (answer.equalsIgnoreCase("y")) {
            System.out.println();
            System.out.println("Thanks for participating! Have the day you deserve :)");
            System.exit(0);
        }
    }



    public static void main(String[] args) {

        System.out.println();
        System.out.println("            Welcome to 'State of the Union!'");
        System.out.println("--------------------------------------------------------");

        AtlasService atlasService = new AtlasServiceReal();
        while (true) {
            StateInfo stateInfo = getState(atlasService);
            if (stateInfo == null) {
                System.out.println();
                System.out.println("I'm sorry, I don't recognize that state");
            }

            else {
                stateInfo.print();
            }
        }
    }
}
