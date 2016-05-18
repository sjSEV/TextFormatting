package com.sirgiy.pack.print;

import com.sirgiy.pack.interfaces.IPrint;

import java.util.ArrayList;

/**
 * PrintText Class
 * To print text on console
 */
public class PrintText implements IPrint {

    private ArrayList<String> printArray;

    /**
     * Default constructor
     */
    public PrintText() {

    }

    /**
     * Set array to print
     * @param localPrintArray of ArrayList<String>
     */
    public void setarray(final ArrayList<String> localPrintArray) {
        this.printArray = localPrintArray;
    }

    /**
     * Print array
     */
    public void printarray() {

        System.out.println();
        System.out.println("***********************************");
        System.out.println("*           Print start           *");
        System.out.println("***********************************");

        for (String temp: printArray) {
            System.out.println(temp);
        }

        System.out.println("***********************************");
        System.out.println("*             Print end           *");
        System.out.println("***********************************");

    }

}
