package com.sirgiy.pack.save;

import com.sirgiy.pack.interfaces.ISave;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * SaveToFile Class
 * To save text on file
 */
public class SaveToFile implements ISave {

    private ArrayList<String> saveArray;

    /**
     * Default constructor
     */
    public SaveToFile() {

    }

    /**
     * set array to save
     * @param  localSaveArray of ArrayList<String>
     */
    public void setarraytosave(final ArrayList<String> localSaveArray) {
        this.saveArray = localSaveArray;
    }

    /**
     * Save array to file
     * @param fileName of String
     */
    public void savearraytofile(final String fileName) {

        BufferedWriter bufferedWriter = null;

        try {

            File fileToSave = new File(fileName);

            System.out.print("Full path where file created: ");
            System.out.println(fileToSave.getCanonicalPath());

            bufferedWriter = new BufferedWriter(new FileWriter(fileToSave));

            for (String temp: saveArray) {
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            try {
                bufferedWriter.close();
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
