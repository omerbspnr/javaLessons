package org.csystem.samples.arraylistapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListApp {
    private static final Scanner ms_kb;
    private static ArrayList<ArrayList<String>> rows;
    private static ArrayList<String> names;

    static  {
        ms_kb = new Scanner(System.in);
        rows = new ArrayList<>();
    }
    private static void getNames(char delim)
    {
        getNames(delim + "");
    }
    private static void getNames(String delim)
    {
        String [] inputNames;

        for (;;) {
            names = new ArrayList<>();

            inputNames = ms_kb.nextLine().trim().split(String.format("[%s]+", delim));

            if (inputNames.length == 1 && inputNames[0].equals("exit"))
                break;

            for (String s : inputNames)
                 names.add(s);

            if (names.isEmpty())
                    continue;

            rows.add( names);

        }

    }
    public static void run()
    {
        getNames(" ");

        ArrayListToXML arrayListToXML = new ArrayListToXML(rows);

        arrayListToXML.showXML();

    }

}
