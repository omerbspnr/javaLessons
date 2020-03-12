package org.csystem.samples.lottaryapp;

import org.csystem.util.ArrayUtil;

import java.util.Random;

public class Lottary {
    private Random m_random;
    public Lottary()
    {
        m_random = new Random();
    }
    public void run()
    {
        ArrayUtil.display(getNumbers());

    }
    private boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];

        int val;

        for (int i = 0; i < 6; ++i) {
            while (true) {
              val = m_random.nextInt(49) + 1;
                if(!flags[val])
                    break;
            }

            flags[val] = true;
        }
        return flags;

    }

    private int [] getNumbers(boolean [] flags)
    {
        int [] numbers = new int[6];
        int index = 0;

        for (int i = 1; i < 50; ++i) {
            if (flags[i])
                numbers[index++] = i;
        }


        return numbers;

    }
    private int [] getNumbers ()
    {


        return getNumbers(getFlags());

    }


    public int [][] getColumns(int n)
    {
        int [][] games = new int[n][];

        for (int i = 0; i  < n; ++i)
            games[i] = getNumbers();

        return games;

    }

}
