package com.sirgiy.pack.interfaces;

import java.util.ArrayList;

/**
 * IFormatting interface
 * To interact ShowMenu class and TextFormatting class
 */
public interface IFormatting {

    /**
     * set array for formatting
     * @param  arrayOfFormatting of ArrayList<String>
     */
    void setarrayofformatting(final ArrayList<String> arrayOfFormatting);

    /**
     * Array format
     * @return ArrayList<String>
     */
    ArrayList<String> getformattedarray();

}
