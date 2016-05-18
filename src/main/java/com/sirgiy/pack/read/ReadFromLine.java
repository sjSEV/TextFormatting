package com.sirgiy.pack.read;

import com.sirgiy.pack.interfaces.IReadFromLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * ReadFromLine Class
 * To read line
 */
public class ReadFromLine implements IReadFromLine {

    /**
     * Default constructor
     */
    public ReadFromLine() {

    }

    /**
     * Read line into an array
     * @return ArrayList<String>
     */
    public ArrayList<String> readline() {

        ArrayList<String> arrayFromLine = new ArrayList<String>();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("To complete reading enter ESC");
        System.out.println("Enter line: ");

        try {

            String temp;

            while (!(temp = bufferedreader.readLine()).equals("ESC")) {
                arrayFromLine.add(temp);
            }

        } catch (IOException e) {
            System.out.println("\nException: " + e.getMessage());
        }

        return arrayFromLine;
    }

}
