package com.sirgiy.pack.menu;

import com.sirgiy.pack.interfaces.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ShowMenu Class
 * To work and display the menu
 */
public class ShowMenu {

    private static final String INPUT_LINE = "1";
    private static final String INPUT_FILE = "2";
    private static final String PRINT_TEXT = "3";
    private static final String TEXT_FORMATTING = "4";
    private static final String SAVE_RESULT = "5";

    private IReadFromLine iReadFromLine;
    private IReadFromFile iReadFromFile;
    private IPrint iPrint;
    private ISave iSave;
    private IFormatting iFormatting;

    private ArrayList<String> inputText;

    /**
     * Default constructor
     */
    public ShowMenu() {

    }

    /**
     * Print menu
     */
    private void printmenu() {
        System.out.println();
        System.out.println("+---------------------------------+");
        System.out.println("| 1 - input from line             |");
        System.out.println("| 2 - input from file             |");
        System.out.println("| 3 - print text                  |");
        System.out.println("| 4 - text formatting             |");
        System.out.println("| 5 - save result                 |");
        System.out.println("| exit - to exit from application |");
        System.out.println("+---------------------------------+");
        System.out.println();
    }

    /**
     * Interaction with the class ReadFromLine
     * @param localIReadFromLine of IReadFromLine
     */
    public void setireadfromline(final IReadFromLine localIReadFromLine) {
        this.iReadFromLine = localIReadFromLine;
    }

    /**
     * Interaction with the class ReadFromFile
     * @param localIReadFromFile of IReadFromFile
     */
    public void setireadfromfile(final IReadFromFile localIReadFromFile) {
        this.iReadFromFile = localIReadFromFile;
    }

    /**
     * Interaction with the class PrintText
     * @param localIPrint of IPrint
     */
    public void setiprint(final IPrint localIPrint) {
        this.iPrint = localIPrint;
    }

    /**
     * Interaction with the class SaveToFile
     * @param localISave of ISave
     */
    public void setisave(final ISave localISave) {
        this.iSave = localISave;
    }

    /**
     * Interaction with the class TextFormatting
     * @param localIFormatting of IFormatting
     */
    public void setiformatting(final IFormatting localIFormatting) {
        this.iFormatting = localIFormatting;
    }

    /**
     * get an array from line
     */
    private void getfromline() {
        this.inputText = this.iReadFromLine.readline();
    }

    /**
     * get an array from line
     */
    private void getfromfile(final String fileName) {
        this.inputText = this.iReadFromFile.readfile(fileName);
    }

    /**
     * get formatted array
     */
    private void getformattedtext() {
        this.iFormatting.setarrayofformatting(this.inputText);
        this.inputText = this.iFormatting.getformattedarray();
    }

    /**
     * Work with console
     */
    public void showmenu() {
        printmenu();
        System.out.print("Select an action: ");

        Scanner scannerLine = new Scanner(System.in);

        try {

            String temp;
            boolean ifDefault;
            boolean ifArrayIsNull;

            while (!(temp = scannerLine.nextLine()).equals("exit")) {
                ifDefault = false;
                ifArrayIsNull = false;
                switch (temp) {
                    case INPUT_LINE:
                        getfromline();
                        System.out.println("Line has been successfully read.");
                        break;
                    case INPUT_FILE:
                        System.out.print("Enter full path of file: ");
                        temp = scannerLine.nextLine();
                        getfromfile(temp);
                        if (this.inputText != null) {
                            System.out.println("File has been read successfully.");
                        }
                        break;
                    case PRINT_TEXT:
                        if (this.inputText != null) {
                            this.iPrint.setarray(this.inputText);
                            this.iPrint.printarray();
                        } else {
                            printmenu();
                            System.out.println("***********************************");
                            System.out.println("* Error: array is null!           *");
                            System.out.println("* No data for print.              *");
                            System.out.println("***********************************");
                            System.out.println();
                            System.out.print("Select an action: ");
                            ifArrayIsNull = true;
                        }
                        break;
                    case TEXT_FORMATTING:
                        if (this.inputText != null) {
                            getformattedtext();
                            System.out.println("The text was formatted.");
                        } else {
                            printmenu();
                            System.out.println("***********************************");
                            System.out.println("* Error: array is null!           *");
                            System.out.println("* No data to format the text      *");
                            System.out.println("***********************************");
                            System.out.println();
                            System.out.print("Select an action: ");
                            ifArrayIsNull = true;
                        }
                        break;
                    case SAVE_RESULT:
                        if (this.inputText != null) {
                            this.iSave.setarraytosave(this.inputText);
                            this.iSave.savearraytofile("testOutput.txt");
                            System.out.println("File has been write successfully.");
                        } else {
                            printmenu();
                            System.out.println("***********************************");
                            System.out.println("* Error: array is null!           *");
                            System.out.println("* No data for save to file.       *");
                            System.out.println("***********************************");
                            System.out.println();
                            System.out.print("Select an action: ");
                            ifArrayIsNull = true;
                        }
                        break;
                    default:
                        printmenu();
                        System.out.println("***********************************");
                        System.out.println("* Warning: invalid action!        *");
                        System.out.println("***********************************");
                        System.out.println();
                        System.out.print("Select an action: ");
                        ifDefault = true;
                        break;

                }

                if (!ifDefault & !ifArrayIsNull) {
                    printmenu();
                    System.out.print("Select an action: ");
                }
            }

        } catch (Exception e) {
            System.out.println("\nException: " + e.getMessage());
        } finally {
            try {
                scannerLine.close();
            } catch (Exception e) {
                System.out.println("\nException: " + e.getMessage());
            }
        }
    }
}
