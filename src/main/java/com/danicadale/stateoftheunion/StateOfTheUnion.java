package com.danicadale.stateoftheunion;

import java.util.Arrays;
import java.util.Scanner;



public class StateOfTheUnion {


    public static void main(String[] args) {

        System.out.println("Hello from the real main");

        Menu stateFactsMenu
                = new Menu(Arrays.asList(new Choice("F", "Unlock a super fun fact!"),
                                         new Choice("H", "Learn a piece of this state's history!"),
                                         new Choice("C", "Choose another state"),
                                         new Choice("Q", "Quit")));
        String selection = stateFactsMenu.getSelection();
        System.out.println("Ah ha! I see you have choosen " + selection + ", a fatal mistake >:)");

        StateInfo oregon = new StateInfo("Oregon", "OR", "Salem", "Oregon Grape",
                                         "Western Meadowlark", "It sux here.", "Formed 1848");
        oregon.print();
        AtlasService atlasService = new AtlasServiceMock();
        while(true) {
            System.out.print("\nEnter state name or abbr: ");
            StateInfo stateInfo = atlasService.lookUp(new Scanner(System.in).nextLine());
            if (stateInfo == null) break;
            else stateInfo.print();
        }

    }

}
