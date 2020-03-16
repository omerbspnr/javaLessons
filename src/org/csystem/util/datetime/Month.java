package org.csystem.util.datetime;

public enum Month {
    JAN(31), FEB(28), MAR(31), APR(30), MAY(31), JUN(30),
    JUL(31), AUG(31), SEP(30), OCT(31), NOV(30), DEC(31);
    private int m_days;

    static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
    Month(int days)
    {
        m_days = days;
    }

    int getDaysByYear(int year)
    {
        return isLeapYear(year) && ordinal() == 1 ? 29 : m_days;
    }
}
