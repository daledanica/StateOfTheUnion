package com.danicadale.stateoftheunion;

import java.util.Collection;
import java.util.Scanner;



public class Menu {

    private final Collection<Choice> choices;



    public Menu(Collection<Choice> choices) {

        this.choices = choices;
    }



    public void print() {

        System.out.println();
        for (Choice choice : choices) {
            System.out.println(choice.getSelector() + ": " + choice.getDescription());
        }
    }



    public String getSelection() {

        print();
        Scanner scanner = new Scanner(System.in);
        String selector = null;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Please enter one of the above choices: ");
            selector = findChoice(scanner.nextLine());
            if (selector != null) {
                validChoice = true;
            }
            else {
                System.out.println(
                        "Sorry, that wasn't a valid option. Please choose one of the above options.");
            }
        }
        return selector;
    }



    private String findChoice(String selector) {

        for (Choice choice : choices) {
            if (choice.getSelector().equalsIgnoreCase(selector)) {
                return choice.getSelector();
            }
        }
        return null;
    }

}
