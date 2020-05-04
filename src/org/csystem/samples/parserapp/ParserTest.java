package org.csystem.samples.parserapp;

import java.util.Scanner;

public class ParserTest {
    private static String getString()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Bir yazı giriniz:");

        return kb.nextLine();
    }

    public static void run()
    {
        String str = getString();
        StringSource ss = new StringSource(str);
        CharArraySource cs = new CharArraySource(str);
        Parser p = new Parser(ss);

        p.doParse();
        p.setSource(cs);
        p.doParse();
    }
}
