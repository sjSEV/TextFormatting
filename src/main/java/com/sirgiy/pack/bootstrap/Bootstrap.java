package com.sirgiy.pack.bootstrap;


import com.sirgiy.pack.formatting.TextFormatting;
import com.sirgiy.pack.menu.ShowMenu;
import com.sirgiy.pack.print.PrintText;
import com.sirgiy.pack.read.ReadFromFile;
import com.sirgiy.pack.read.ReadFromLine;
import com.sirgiy.pack.save.SaveToFile;

/**
 * Bootstrap Class
 * Entry point
 */
public final class Bootstrap {

    /**
     * Default constructor
     */
    private Bootstrap() {

    }

    /**
     * Entry point
     * @param args of string
     */
    public static void main(final String[] args) {

        ShowMenu showmenu = new ShowMenu();
        showmenu.setireadfromline(new ReadFromLine());
        showmenu.setireadfromfile(new ReadFromFile());
        showmenu.setiprint(new PrintText());
        showmenu.setisave(new SaveToFile());
        showmenu.setiformatting(new TextFormatting());
        showmenu.showmenu();
    }
}
