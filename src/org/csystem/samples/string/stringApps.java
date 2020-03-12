package org.csystem.samples.string;

public class stringApps {
    public static String squeeze(String str)
    {
        int begin = 0;
        int end  = str.length() - 1;

        while (Character.isWhitespace(str.charAt(begin)))
            ++begin;
        System.out.println(str.charAt(begin));

        while (Character.isWhitespace(str.charAt(end)))
            --end;
        ++end;


        char [] delims = {'(', ')'};
        char [] chars = new char[end  - begin + delims.length];

        for (int i = 1; i <= end - begin; ++i) {
            chars[i] = str.charAt(begin - 1 + i);
        }
        chars[0] = delims[0];
        chars[chars.length - 1] = delims[1];

        return new String(chars);
    }

    public static String changeCase (String s) {
        char [] chars = new char[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                if (ch >= 'A' && ch <= 'Z')
                    chars[i] = Character.toLowerCase(ch);
                if (ch >= 'a' && ch <= 'z')
                    chars[i] = Character.toUpperCase(ch);
            }
            else
                chars[i] = ch;
        }

        return new String(chars);
    }
}
