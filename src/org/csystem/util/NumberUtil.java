/*----------------------------------------------------------------------------------------------------------------------
	NumberUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public final class NumberUtil {
	private static final String [] ms_onesTR;
	private static final String [] ms_tensTR;

	static {
		ms_onesTR = new String[]{"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
		ms_tensTR = new String[]{"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
	}

	private NumberUtil() {}
	private static String numToTextMax3DigitsTR(int val)
	{
		if (val == 0)
			return "sıfır";

		String str = val < 0 ? "eksi" : "";

		val = Math.abs(val);

		int a = val / 100;
		int b = val / 10 % 10;
		int c = val % 10;

		if (a != 0) {
			if (a != 1)
				str += ms_onesTR[a];
			str += "yüz";
		}

		if (b != 0)
			str += ms_tensTR[b];

		if (c != 0)
			str += ms_onesTR[c];

		return str;
	}

	private static int [] getDigits(int n, int val)
	{
		val = Math.abs(val);
		int len = val == 0 ? 1 : (int)Math.log10(val) / n + 1;
		int [] a = new int[len];

		for (int i = len - 1; i >= 0; --i) {
			int pow = (int)Math.pow(10, n);

			a[i] = val % pow;
			val /= pow;
		}

		return a;
	}

	public static long factorial(int n)
	{
		if (n < 0)
			return -1;
		
		long result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;			
		
		return result;
	}

	public static int [] getDigits(int val)
	{
		return getDigits(1, val);
	}

	public static int [] getDigitsInThree(int val)
	{
		return getDigits(3, val);
	}
	
	public static int getDigitsCount(int val)
	{		
		return val == 0 ? 1 : (int)Math.log10(Math.abs(val)) + 1;
	}
	
	public static int getDigitsSum(int val)
	{
		int sum = 0;
		
		while (val != 0) {
			sum += val % 10;
			val /= 10;
		}
		
		return Math.abs(sum);
	}
	
	public static int getNextFibonacciNumber(int val)
	{
		if (val < 0)
			return 0;
		
		int prev1 = 0, prev2 = 1, number = 0;
		
		for (;;) {
			number = prev1 + prev2;
			if (number > val)
				return number;
				
			prev1 = prev2;
			prev2 = number;			
		}			
	}	
	
	public static int getFibonnaciNumber(int n)
	{
		if (n <= 0)
			return -1;
		
		if (n <= 2)
			return n - 1;
		
		int prev1 = 0, prev2 = 1, val = 0;
		
		for (int i = 2; i < n; ++i) {
			val = prev1 + prev2;
			prev1 = prev2;
			prev2 = val;
		}		
		
		return val;		
	}	
	
	public static int getPrime(int n)
	{
		if (n <= 0)
			return -1;
		
		int count = 0, val = 0;
		
		for (int i = 2; count < n; ++i) {
			if (isPrime(i)) {
				++count;
				val = i;
			}
		}		
		
		return val;		
	}

	public static int getRandom4DigitsNumber()
	{
		return getRandom4DigitsNumber(new Random());
	}

	public static int getRandom4DigitsNumber(Random r)
	{
		boolean [] flags = new boolean[10];
		int result = 0;
		int val = r.nextInt(9) + 1;

		flags[val] = true;
		result = val * 1000;

		for (int i = 3; i >= 1; --i) {
			for (;;) {
				val = r.nextInt(10);
				if (!flags[val])
					break;
			}
			result += val * (int)Math.pow(10, i - 1);
			flags[val] = true;
		}

		return result;
	}
	
	public static int getReverse(int val)
	{
		int rev = 0;
		
		while (val != 0) {
			rev = rev * 10 + val % 10;
			val /= 10;
		}
		
		return rev;
	}
	
	public static int getSum(int val)
	{
		int n = getDigitsCount(val);
		
		int sum = 0;
		
		while (val != 0) {
			sum += pow(val % 10, n);
			val /= 10;			
		}
		
		return sum;
	}
	
	public static boolean isArmstrong(int val)
	{
		if (val < 0)
			return false;
		
		return val == getSum(val);		
	}
	
	public static boolean isEven(int val)
	{
		return val % 2 == 0;
	}
	
	public static boolean isNegative(int val)
	{
		return val < 0;				
	}
	
	public static boolean isOdd(int val)
	{
		return !isEven(val);
	}
	
	public static boolean isPalindrome(int val)
	{
		return getReverse(val) == val;
	}
	
	public static boolean isPrime(int val)
	{
		if (val <= 1)
			return false;
		
		if (val % 2 == 0)
			return val == 2;
		
		if (val % 3 == 0)
			return val == 3;
		
		if (val % 5 == 0)			
			return val == 5;
		
		if (val % 7 == 0)			
			return val == 7;
		
		for (int i = 11; i * i <= val; i += 2)
			if (val % i == 0)
				return false;
		
		return true;			
	}
	
	public static boolean isPositive(int val)
	{
		return val > 0;
	}
	
	public static int pow(int a, int b)
	{
		b = Math.abs(b);
		int result = 1;
		
		while (b-- > 0)
			result *= a;
		
		return result;
	}
}
