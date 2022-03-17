package com.danicadale.stateoftheunion;


/**
 * This is the main class for this application
 *
 * @author Danica Dale
 * @since January 2022
 */
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

            // call teammate's microservice to return state info
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

        // connect to the remote Microservice
        AtlasService atlasService = new AtlasServiceReal();

        // getState() will do a direct exit for us
        //noinspection InfiniteLoopStatement
        while (true) {
            StateInfo stateInfo = getState(atlasService);
            stateInfo.print();
        }
    }
}
