/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public final class StringUtil {
	private static final String ms_alphabetTR;
	private static final String ms_alphabetEN;

	static {
		ms_alphabetTR = "abcçdefgğhıijklmnoöprsştuüvyz";
		ms_alphabetEN = "abcdefghijklmnopqrstuwvxyz";
	}

	private StringUtil() {}
	public static String capitalize(String str)
	{
		str = str.trim();

		return !str.isEmpty() ? Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase() : "";
	}

	public static int getCount(String s1, String s2)
	{
		int count = 0;
		
		for (int index = -1; (index = s1.indexOf(s2, index + 1)) != -1; ++count)
				;	
		
		return count;
	}

	public static String generateRandomPassword(Random r, int n)
	{
		String chars = "abcçdefgğhıijklmnoöpqrsştuüwxvyz0123456789.:?-_";

		return getRandomText(r, n, chars);
	}

	public static String generateRandomPassword(int n)
	{
		return generateRandomPassword(new Random(), n);
	}

	public static String getRandomString(Random r, int n, String str)
	{
		char [] c = new char[n];

		for (int i = 0; i < n; ++i)
			c[i] = str.charAt(r.nextInt(str.length()));

		return new String(c);
	}

	public static String getRandomText(Random r, int n, String str)
	{
		char [] c = new char[n];

		for (int i = 0; i < n; ++i) {
			char ch = str.charAt(r.nextInt(str.length()));

			c[i] = r.nextBoolean() ? Character.toUpperCase(ch) : ch;
		}

		return new String(c);
	}

	public static String getRandomTextEN(Random r, int n)
	{
		return getRandomText(r, n, ms_alphabetEN);
	}

	public static String getRandomTextEN(int n)
	{
		return getRandomTextEN(new Random(), n);
	}

	public static String getRandomTextTR(Random r, int n)
	{
		return getRandomText(r, n, ms_alphabetTR);
	}

	public static String getRandomTextTR(int n)
	{
		return getRandomTextTR(new Random(), n);
	}

	public static boolean isPalindrome(String s)
	{
		s = removeNonalphabetics(s);
		
		int len = s.length();
		int halfLen = len / 2;
		
		for (int i = 0; i < halfLen; ++i) {
			char ch1 = Character.toLowerCase(s.charAt(i));
			char ch2 = Character.toLowerCase(s.charAt(len - 1 - i));
			
			if (ch1 != ch2)
				return false;
		}
		
		return true;		
	}

	public static boolean isPangram(String s, String alphabet)
	{
		int len = alphabet.length();
		
		for (int i = 0; i < len; ++i)
			if (!s.contains(alphabet.charAt(i) + ""))
				return false;
		
		return true;		
	}
	
	public static boolean isPangramTR(String s)
	{
		return isPangram(s.toLowerCase(), ms_alphabetTR);
	}
	
	public static boolean isPangramEN(String s)
	{
		return isPangram(s.toLowerCase(), ms_alphabetEN);
	}

	public static String padLeft(String s, int len, char ch)
	{
		if (len <= s.length())
			return s;

		return repeat(len - s.length(), ch) + s;
	}

	public static String padLeft(String s, int len)
	{
		return padLeft(s, len, ' ');
	}

	public static String padRight(String s, int len, char ch)
	{
		if (len <= s.length())
			return s;

		return s + repeat(len - s.length(), ch);
	}

	public static String padRight(String s, int len)
	{
		return padRight(s, len, ' ');
	}

	public static String removeNonalphabetics(String s)
	{
		String str = "";

		int len = s.length();

		for (int i = 0; i < len; ++i) {
			char ch = s.charAt(i);

			if (Character.isLetter(ch))
				str += ch;
		}

		return str;
	}

	public static String repeat(int n, char ch)
	{
		char [] c = new char[n];

		while (n-- > 0)
			c[n] += ch;

		return new String(c);
	}

	public static String reverse(String str)
	{
		char [] c = str.toCharArray();

		ArrayUtil.reverse(c);

		return new String(c);
	}

	public static String [] split(String str, String delim)
	{
		return split(str, delim, StringSplitOptions.NONE);
	}

	public static String [] split(String str, String delim, StringSplitOptions stringSplitOptions)
	{
		String specials = "[].";
		String re = "[";

		for (int i = 0; i < delim.length(); ++i) {
			char ch = delim.charAt(i);

			re += specials.indexOf(ch) >= 0 ? "\\" + ch : ch;
		}

		re += "]";

		if (stringSplitOptions == StringSplitOptions.REMOVEEMPTYENTRIES)
			re += "+";

		return str.split(re);
	}

	public static String trimEnd(String s)
	{
		int i;

		for (i = s.length() - 1; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
			;

		return s.substring(0, i + 1);
	}

	public static String trimStart(String s)
	{
		int i;

		int len = s.length();

		for (i = 0; i < len && Character.isWhitespace(s.charAt(i)); ++i)
			;

		return s.substring(i);
	}
}
