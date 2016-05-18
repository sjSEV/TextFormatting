package com.sirgiy.pack.interfaces;

import java.util.ArrayList;

/**
 * IReadFromFile interface
 * To interact ShowMenu class and ReadFromLine class
 */
public interface IReadFromFile {

    /**
     * get array from file
     * @param fileName of String
     * @return ArrayList<String>
     */
    ArrayList<String> readfile(final String fileName);
}
