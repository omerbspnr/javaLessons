package org.csystem.samples.arraylistapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {
    private static Scanner ms_kb;
    private static ArrayList rows;
    private static ArrayList names;

    static  {
        ms_kb = new Scanner(System.in);
        rows = new ArrayList();
    }

    private static void getNames()
    {
        String [] inputNames = null;
        for (;;)
        {
            names = new ArrayList();

            inputNames = ms_kb.nextLine().trim().split("[ ]+");

            if (inputNames.length == 1 && inputNames[0].equals("exit"))
                break;

            for (String s : inputNames)
                 names.add(s);

            if (names.isEmpty())
                    continue;

            rows.add(names);
        }

    }
    public static void run()
    {
        getNames();

        var arrayListApp = new ArrayListApp(rows);

        rows.clear();

    }

}
