/*----------------------------------------------------------------------------------------------------------------------
    ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public class ArrayUtil {
    private ArrayUtil() {}
    public static double average(int [] a)
    {
        return  (double)sum(a) / a.length;
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }

    public static void bubbleSort(int [] a, boolean desc)
    {
        if (desc) {
            for (int i = 0; i < a.length - 1; ++i) {
                for (int k = 0; k < a.length - 1 - i; ++k)
                    if (a[k] < a[k + 1]) {
                        int temp = a[k];
                        a[k] = a[k + 1];
                        a[k + 1] = temp;
                    }
            }
        }
        else {
            for (int i = 0; i < a.length - 1; ++i) {
                for (int k = 0; k < a.length - 1 - i; ++k)
                    if (a[k] > a[k + 1]) {
                        int temp = a[k];
                        a[k] = a[k + 1];
                        a[k + 1] = temp;
                    }
            }
        }
    }

    public static void display(int [] a)
    {
        display(a, 1);
    }

    public static void display(int [] a, int n)
    {
        String fmt = String.format("%%0%dd ", n);

        for (int val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void display(int [][] a)
    {
        display(a, 1);
    }
    public static void display(int [][] a, int n)
    {
        for (int [] array : a)
            display(array, n);
    }

    public static void drawHistogram(int [] hist, int n, char ch)
    {
        int maxVal = max(hist);

        for (int val : hist) {
            int nCh = val * n / maxVal;

            while (nCh-- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static int [] getHistogramData(int [] a, int n) //[0, n]
    {
        int [] counts = new int[n + 1];

        for (int val : a)
            ++counts[val];

        return counts;
    }

    public static int[] getRandomArray(int n, int min, int max) //[min, max)
    {
        return getRandomArray(new Random(), n, min, max);
    }

    public static int[] getRandomArray(Random r, int n, int min, int max) //[min, max)
    {
        int [] a = new int[n];

        for (int i = 0; i < n; ++i)
            a[i] = r.nextInt(max - min) + min;

        return a;
    }

    public static int[][] getRandomMatrix(int m, int n, int min, int max) //[min, max)
    {
        return getRandomMatrix(new Random(), m, n, min, max);
    }

    public static int[][] getRandomMatrix(Random r, int m, int n, int min, int max) //[min, max)
    {
        int [][] a = new int[m][];

        for (int i = 0; i < m; ++i)
            a[i] = getRandomArray(r, n, min, max);

        return a;
    }

    public static int [][] getRandomSquareMatrix(int n, int min, int max)
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }

    public static int [][] getRandomSquareMatrix(Random r, int n, int min, int max)
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static int [][] getTransposedMatrix(int [][] a)
    {
        if (!isMatrix(a))
            return new int[0][];

        int row = a[0].length;
        int col = a.length;
        int [][] t = new int[row][col];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                t[i][j] = a[j][i];

        return t;
    }

    public static boolean isMatrix(int [][] a)
    {
        int col = a[0].length;

        for (int i = 1; i < a.length; ++i)
            if (a[i].length != col)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static String join(String [] s, char delim)
    {
        return join(s, delim + "");
    }

    public static  String join(String [] s, String delim)
    {
        String str = "";

        for (String sval : s)
            str += sval + delim;

        return str.substring(0, str.length() - delim.length());
    }

    public static int max(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            result = Math.max(result, a[i]);

        return result;
    }

    public static int min(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            result = Math.min(result, a[i]);

        return result;
    }

    public static void reverse(int [] a) //by Emre Onsur
    {
        int temp;
        int halfLen = a.length / 2;

        for(int i = 0; i < halfLen; ++i) {
            temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }

    public static void reverse(char [] a)
    {
        char temp;
        int halfLen = a.length / 2;

        for(int i = 0; i < halfLen; ++i) {
            temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }

    public static int sum(int [] a)
    {
        int result = 0;

        for (int val : a)
            result += val;

        return result;
    }

    public static int sumDiagonal(int [][] a)
    {
        //...
        int sum = 0;

        for (int i = 0; i < a.length; ++i)
            sum += a[i][i];

        return sum;
    }
}
