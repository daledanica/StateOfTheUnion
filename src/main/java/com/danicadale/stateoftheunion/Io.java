package com.danicadale.stateoftheunion;

import java.util.Scanner;



/**
 * Convenience class for performing console IO
 *
 * @author Danica Dale
 * @since January 2022
 */
public class Io {

    private static final Scanner scanner = new Scanner(System.in);



    /**
     * Reads a line of text from the console
     *
     * @return line of text read from console. An empty string is returned if the user hits enter
     * without giving any other input.
     */
    public static String readLine() {

        return scanner.nextLine();
    }

}
