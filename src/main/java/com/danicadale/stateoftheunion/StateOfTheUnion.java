package com.danicadale.stateoftheunion;

import java.util.Arrays;



public class StateOfTheUnion {


    private static StateInfo getState(AtlasService atlasService) {

        while (true) {
            System.out.print("\nEnter state name or abbr (or Q to quit): ");
            String stateName = Io.readLine();
            if (stateName.isBlank()) continue;
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

        Menu stateFactsMenu
                = new Menu(Arrays.asList(new Choice("F", "Unlock a super fun fact!"),
                                         new Choice("H", "Learn a piece of this state's history!"),
                                         new Choice("C", "Choose another state"),
                                         new Choice("Q", "Quit")));

        AtlasService atlasService = new AtlasServiceMock();
        while (true) {
            StateInfo stateInfo = getState(atlasService);
            stateInfo.print();
            boolean inStateMenu = true;
            while (inStateMenu) {
                String choice = stateFactsMenu.getSelection();
                switch (choice.toUpperCase()) {
                    case "Q" -> confirmQuit();
                    case "F" -> stateInfo.printFunFact();
                    case "H" -> stateInfo.printHistoryFact();
                    case "C" -> inStateMenu = false;
                }
            }
        }

    }

}
