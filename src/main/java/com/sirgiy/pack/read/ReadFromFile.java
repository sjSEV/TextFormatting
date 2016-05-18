package com.sirgiy.pack.read;

import com.sirgiy.pack.interfaces.IReadFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * ReadFromFile Class
 * To read file
 */
public class ReadFromFile implements IReadFromFile {

    /**
     * Default constructor
     */
    public ReadFromFile() {

    }

    /**
     * Read file into an array
     * @param fileName of String
     * @return ArrayList<String>
     */
    public ArrayList<String> readfile(final String fileName) {

        ArrayList<String> arrayFromFile = new ArrayList<String>();
        FileReader nameFileReader = null;
        BufferedReader bufferedreader = null;

        try {

            nameFileReader = new FileReader(fileName);
            bufferedreader = new BufferedReader(nameFileReader);

            String temp;

            while ((temp = bufferedreader.readLine()) != null) {
                arrayFromFile.add(temp);
            }

        } catch (Exception e) {
            try {
                System.out.println("Exception: " + e.getMessage());
                arrayFromFile = null;
            } catch (Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }

        return arrayFromFile;
    }
}
