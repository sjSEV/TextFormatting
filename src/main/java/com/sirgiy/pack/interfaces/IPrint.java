package com.sirgiy.pack.interfaces;

import java.util.ArrayList;

/**
 * IPrint interface
 * To interact ShowMenu class and PrintText class
 */
public interface IPrint {

    /**
     * set array to print
     * @param  printArray of ArrayList<String>
     */
    void setarray(final ArrayList<String> printArray);

    /**
     * Print array to console
     */
    void printarray();
}
