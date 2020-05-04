package org.csystem.util;

import java.util.Scanner;

public final class Console {
    private final static Scanner ms_kb;

    static {
        ms_kb = new Scanner(System.in);
    }

    private Console()
    {}

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String msg)
    {
        return readInt(msg, "");
    }

    public static int readInt(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Integer.parseInt(ms_kb.nextLine());
            }
            catch (Throwable ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static int readIntLine(String msg)
    {
        return readInt(msg + "\n", "");
    }

    public static int readIntLine(String msg, String errMsg)
    {
        return readInt(msg + "\n", errMsg + "\n");
    }

    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String msg)
    {
        return readDouble(msg, "");
    }

    public static double readDouble(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Double.parseDouble(ms_kb.nextLine());
            }
            catch (Throwable ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static double readDoubleLine(String msg)
    {
        return readDouble(msg + "\n", "");
    }

    public static double readDoubleLine(String msg, String errMsg)
    {
        return readDouble(msg + "\n", errMsg + "\n");
    }

    public static String read(String msg)
    {
        System.out.print(msg);

        return ms_kb.nextLine();
    }

    public static String readLine(String msg)
    {
        return read(msg + "\n");
    }

    //...
}
