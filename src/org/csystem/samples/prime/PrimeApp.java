package org.csystem.samples.prime;

import org.csystem.util.ArrayUtil;
import org.csystem.util.NumberUtil;

public class PrimeApp {
    boolean [] flags;
    int number;

    public PrimeApp(int val)
    {
        number = val;
        flags = new boolean[10];
    }

    public void calculateDigits()
    {
        int count = NumberUtil.getDigitsCount(number);

        for (int i = 0; i < count; ++i) {
            int n = (int)Math.pow(10, i);
            flags[(number / n) % 10] = true;
            System.out.printf("%d ", number / n % 10);

        }

        System.out.println("--------------------");

    }
    public void calculatePrimes()
    {
        int maxDigit = getMaxDigit();
        int maxValue = 0;
        int count = NumberUtil.getDigitsCount(number);
        while(count-- >= 0)
            maxValue += maxDigit * (int)Math.pow(10, count);

        if(flags[2])
            System.out.println(2);
        for (int i = 3; i < maxValue; i += 2)
            if(NumberUtil.isPrime(i) && isWrittenPrimeNumber(i))
                System.out.println(i);
    }

    public int getMaxDigit()
    {
        for (int i = flags.length - 1; i >= 0; --i )
            if(flags[i])
                return i;

        return -1;
    }
    public boolean isWrittenPrimeNumber(int val)
    {
        int count = NumberUtil.getDigitsCount(val);
        for (int i = 0; i < count; ++i) {
            int n = (int)Math.pow(10,i);

            if (!flags[val / n % 10])
                return false;
        }
        return true;
    }


    public void run()
    {
        calculateDigits();
        calculatePrimes();
    }
}
