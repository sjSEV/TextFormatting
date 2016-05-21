package com.sirgiy.pack.formatting;

import com.sirgiy.pack.interfaces.IFormatting;

import java.util.ArrayList;

/**
 * TextFormatting class
 * To formatting the text
 */
public class TextFormatting implements IFormatting {

    private static final int ONE_LEVEL_SPACE = 4;

    private ArrayList<String> textFormatting;
    private ArrayList<String> formattedText;

    /**
     * Default constructor
     */
    public TextFormatting() {

    }

    /**
     * Add a line wrapping after the symbols: '{', '}', ';'
     * To consider empty strings
     */
    private void addwrapping() {
        String temporaryString;
        int tempInt;

        for (String temp: textFormatting) {
            if (temp.equals("")) {
                formattedText.add(temp);
            }

            tempInt = 0;
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '{') {
                    if ((i + 1) <= temp.length()) {
                        temporaryString = temp.substring(tempInt, i + 1);
                        formattedText.add(temporaryString);
                        tempInt = i + 1;
                    }
                } else if (temp.charAt(i) == '}') {
                    if ((i + 1) <= temp.length()) {
                        temporaryString = temp.substring(tempInt, i + 1);
                        formattedText.add(temporaryString);
                        tempInt = i + 1;
                    }
                } else if (temp.charAt(i) == ';') {
                    if ((i + 1) <= temp.length()) {
                        temporaryString = temp.substring(tempInt, i + 1);
                        formattedText.add(temporaryString);
                        tempInt = i + 1;
                    }
                }
            }
        }
    }

    /**
     * Check the number of spaces depending on the level
     * @param level of int
     * @param temporaryString of StringBuilder
     * @return true or false
     */
    private boolean checklevel(final int level, final StringBuilder temporaryString) {

        int spaseCount = ONE_LEVEL_SPACE * level;
        for (int i = 0; i < spaseCount; i++) {
            if (temporaryString.charAt(i) != ' ') {
                return false;
            }
        }

        return true;
    }

    /**
     * Set indents in the blocks
     */
    private void addindents() {

        textFormatting = formattedText;
        formattedText = new ArrayList<String>();

        StringBuilder temporaryString = new StringBuilder();
        int level = 0;
        char space = ' ';


        for (String temp: textFormatting) {
            if (temp.equals("")) {
                formattedText.add(temp);
                continue;
            }

            if (temp.charAt(temp.length() - 1) == '}') {
                level--;
                if (level < 0) {
                    level = 0;
                }
            }

            if (level >= 0) {
                temporaryString.append(temp);
                while (!(checklevel(level, temporaryString))) {
                    temporaryString.insert(0, space);
                }
                formattedText.add(temporaryString.toString());
                temporaryString.setLength(0);
            }

            if (temp.charAt(temp.length() - 1) == '{') {
                level++;
            }
        }
    }

    /**
     * Check spaces in the blocks
     */
    private void checkspaces() {

    }

    /**
     * set array to formatting
     * @param  localTextFormatting of ArrayList<String>
     */
    public void setarrayofformatting(final ArrayList<String> localTextFormatting) {
        this.textFormatting = localTextFormatting;
    }

    /**
     * Save array to file
     * @return ArrayList<String>
     */
    public ArrayList<String> getformattedarray() {

        try {

            formattedText = new ArrayList<String>();

            addwrapping();
            addindents();
            checkspaces();

        } catch (Exception e) {
            System.out.println("\nException: " + e.getMessage());
        }

        return this.formattedText;
    }
}
