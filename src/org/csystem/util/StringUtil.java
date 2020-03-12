/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public class StringUtil {
	private static String ms_alphabetTR = "abcçdefgğhıijklmnoöprsştuüvyz";
	private static String ms_alphabetEN = "abcdefghijklmnopqrstuwvxyz";

	private StringUtil(){}
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

	public static String generateRandomPassword(java.util.Random r, int n)
	{
		String chars = "abcçdefgğhıijklmnoöpqrsştuüwxvyz0123456789.:?-_";

		char [] c = new char[n];

		for (int i = 0; i < n; ++i)  {
			char ch = chars.charAt(r.nextInt(chars.length()));

			c[i] = r.nextBoolean() ? Character.toUpperCase(ch) : ch;
		}

		return new String(c);
	}

	public static String generateRandomPassword(int n)
	{
		return generateRandomPassword(new java.util.Random(), n);
	}

	public static String getRandomString(java.util.Random r, int n, String str)
	{
		char [] c = new char[n];

		for (int i = 0; i < n; ++i)
			c[i] = str.charAt(r.nextInt(str.length()));

		return new String(c);
	}

	public static String getRandomText(Random r, int n, String alphabet)
	{
		char [] c = new char[n];

		for (int i = 0; i < n; ++i) {
			char ch = alphabet.charAt(r.nextInt(alphabet.length()));

			c[i] = r.nextBoolean() ? Character.toUpperCase(ch) : ch;
		}

		return new String(c);
	}

	public static String getRandomTextEN(java.util.Random r, int n)
	{

		return getRandomText(r, n, ms_alphabetEN);
	}

	public static String getRandomTextEN(int n)
	{
		return getRandomTextEN(new java.util.Random(), n);
	}

	public static String getRandomTextTR(java.util.Random r, int n)
	{
		return getRandomText(r, n, ms_alphabetTR);
	}
	public static int getLetterCount(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);

			if (Character.isLetter(ch))
				++count;
		}

		return count;
	}
	public static String getRandomTextTR(int n)
	{
		return getRandomTextTR(new java.util.Random(), n);
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
		return isPangram(s.toLowerCase(), "ms_alphabetTR");
	}

	public static boolean isPangramEN(String s)
	{
		return isPangram(s.toLowerCase(), "ms_alphabetEN");
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

		int len = s.length();
		char [] chars = new char[getLetterCount(s)];
		int idx = 0;

		for (int i = 0; i < len; ++i) {
			char ch = s.charAt(i);

			if (Character.isLetter(ch))
				chars[idx++] = ch;
		}
		return new String(chars);
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

