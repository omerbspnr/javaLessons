package org.csystem.samples.parserapp;

public class StringSource implements ISource {
    private final String m_str;
    private final int m_length;
    private int m_index;

    public StringSource(String str)
    {
        m_str = str;
        m_length = m_str.length();
    }

    public int getChar()
    {
        return m_index == m_length ? -1 : m_str.charAt(m_index++);
    }
}
