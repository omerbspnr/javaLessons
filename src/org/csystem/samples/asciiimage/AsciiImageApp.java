package org.csystem.samples.asciiimage;

import java.util.Scanner;

public class AsciiImageApp {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1);

    }
    private static void controlImage(String [] image)
    {
        for (int i = 1; i < image.length; ++i)
            if (image[i].length() != image[i - 1].length())
                doWorkForException("Invalid image");
    }

    private static String [] getImages(int n)
    {
        String [] image = new String[n];

        for (int i = 0; i < n; ++i)
            image[i] = SCANNER.nextLine();

        controlImage(image);
        return image;
    }

    public static void run()
    {
        System.out.print("Kaç satır girmek istiyorsunuz");

        int n = Integer.parseInt(SCANNER.nextLine());
        String [] images = ("........................................\n" +
                "...................................MM...\n" +
                "..............................MMMMMM,...\n" +
                ".........................,MMMMMMMMMM....\n" +
                "....................,MMMMMMMMMMMMMM.....\n" +
                "................MMMMMMMMMMMMMMMMMMM.....\n" +
                "..................MMMMMMMMMMMMMMMM......\n" +
                "...................MMMMMMMMMMMMMMM......\n" +
                "..................MMMMMMMMMMMMMMM,......\n" +
                "................+MMMMMMMMMMMMMMMM.......\n" +
                "...............MMMMMMMMMMMMMMMMM........\n" +
                ".............MMMMMMMMMMMMMMMMMMM........\n" +
                "............MMMMMMMMMMMMMM.MMMM,........\n" +
                "..........MMMMMMMMMMMMMM+....MM.........\n" +
                "........+MMMMMMMMMMMMMM.................\n" +
                ".......MMMMMMMMMMMMMM...................\n" +
                ".....MMMMMMMMMMMMMMM....................\n" +
                "....MMMMMMMMMMMMMM......................\n" +
                "..MMMMMMMMMMMMMM+.......................\n" +
                "..MMMMMMMMMMMMM.........................\n" +
                "....MMMMMMMMM...........................\n" +
                ".....MMMMMMM............................\n" +
                ".......MMM..............................\n" +
                "........................................").split("[\n]");

        AsciiImage a = new AsciiImageChar(images);
        a.flipv();
        a.disp();
        a.flipv();
        a.disp();
    }

}

