package com.sirgiy.pack.interfaces;

import java.util.ArrayList;

/**
 * ISave Interface
 * To interact ShowMenu class and SaveToFile class
 */
public interface ISave {

    /**
     * set array to save
     * @param  saveArray of ArrayList<String>
     */
    void setarraytosave(final ArrayList<String> saveArray);

    /**
     * Save array to file
     * @param fileName of String
     */
    void savearraytofile(final String fileName);
}
