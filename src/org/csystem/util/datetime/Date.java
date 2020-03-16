/*----------------------------------------------------------------------------------------------------------------------
    Date sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Date {
    private static final String [] ms_weekDaysTR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
    private static final String [] ms_weekDaysEN = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    private static final String[] ms_monthsOfYearTR = {"","Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz",
            "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
    private static final String[] ms_monthsOfYearEN = {"","Jan", "Feb", "Mar", "Apr", "May","Jun","Jul","Aug", "Sep","Oct", "Nov", "Dec"};


    private int m_day, m_mon, m_year;
    private int m_dayOfWeek;

    private static int getDayOfWeek(int day, int mon, int year)
    {
        int totalDays = getDayOfYear(day, mon, year);

        for (int y = 1900; y < year; ++y)
            totalDays += Month.isLeapYear(y) ? 366 : 365;

        return totalDays % 7;
    }

    private static int getDayOfYear(int day, int mon, int year)
    {
        int dayOfYear = day;

        for (int m = 0; m < mon; ++m)
            dayOfYear += Month.values()[m].getDaysByYear(year);

        return dayOfYear;
    }

    private static boolean isValidDate(int day, int mon, int year)
    {
        if (day < 1 || day > 31 || mon < 1 || mon > 12)
            return false;

        int days =  Month.values()[mon - 1].getDaysByYear(year);

        return day <= days;
    }

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1); //exception konusuna kadar sabredin
    }

    private static void control(int day, int mon, int year, String msg)
    {
        if (!isValidDate(day, mon, year))
            doWorkForException(msg);
    }
    private static String postFixForDay(int day)
    {
        String str = "th";

        switch (day) {
            case 1:
            case 21:
            case 31: str = "st"; break;
            case 2 :
            case 22: str = "nd"; break;
            case 3:
            case 23: str = "rd"; break;
        }

        return str;
    }
    private void controlForDay(int day)
    {
        control(day, m_mon, m_year, "Invalid day");
    }

    private void controlForMonValue(int monVal)
    {
        control(m_day, monVal, m_year, "Invalid month");
    }

    private void controlForYear(int year)
    {
        control(m_day, m_mon, year, "Invalid year");
    }

    private void set(int day, int mon, int year)
    {
        m_day = day;
        m_mon = mon;
        m_year = year;
        m_dayOfWeek = getDayOfWeek(m_day, m_mon, m_year);
    }

    private int getDayOfWeekValue() {return m_dayOfWeek;}

    public static Date randomDate()
    {
        return randomDate(new Random());
    }

    public static Date randomDate(Random r)
    {
        Date now = new Date();

        return randomDate(r, now.m_year, now.m_year);
    }

    public static Date randomDate(int year)
    {
        return randomDate(new Random(), year);
    }

    public static Date randomDate(Random r, int year)
    {
        return randomDate(r, year, year);
    }
    public static Date randomDate(int minYear, int maxYear)
    {
        return randomDate(new Random(), minYear, maxYear);
    }

    public static Date randomDate(Random r, int minYear, int maxYear)
    {
        int year = r.nextInt(maxYear - minYear + 1) + minYear;
        int mon = r.nextInt(12) + 1;
        int days =  Month.values()[mon - 1].getDaysByYear(year);
        int day = r.nextInt(days) + 1;

        return new Date(day, mon, year);
    }

    public Date()
    {
        Calendar now = Calendar.getInstance();

        set(now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1, now.get(Calendar.YEAR));
    }

    public Date(int day, Month month, int year)
    {
        control(day, month.ordinal() + 1, year, "Invalid date");
        set(day, month.ordinal() + 1, year);
    }

    public Date(int day, int mon, int year)
    {
        control(day, mon, year, "Invalid date");
        set(day, mon, year);
    }

    public void setDay(int day)
    {
        if (day == m_day)
            return;

        controlForDay(day);
        set(day, m_mon, m_year);
    }

    public void setMonth(Month month)
    {
        setMonthValue(month.ordinal() + 1);
    }

    public void setMonthValue(int mon)
    {
        if (m_mon == mon)
            return;

        controlForMonValue(mon);
        set(m_day, mon, m_year);
    }

    public void setYear(int year)
    {
        if (m_year == year)
            return;

        controlForYear(year);
        set(m_day, m_mon, year);
    }

    public int getDay()
    {
        return m_day;
    }
    public int getMonthValue()
    {
        return m_mon;
    }
    public Month getMonth() {return Month.values()[m_mon - 1];}
    public int getYear()
    {
        return m_year;
    }
    public DayOfWeek getDayOfWeek() {return DayOfWeek.values()[getDayOfWeekValue()];}
    public String getDayOfWeekTR() {return ms_weekDaysTR[getDayOfWeekValue()];}
    public String getDayOfWeekEN() {return ms_weekDaysEN[getDayOfWeekValue()];}
    public int getDayOfYear() {return getDayOfYear(m_day, m_mon, m_year);}

    public boolean isLeapYear()
    {
        return  Month.isLeapYear(m_year);
    }

    public boolean isWeekend()
    {
        return m_dayOfWeek == 0 || m_dayOfWeek == 6;
    }

    public boolean isWeekday()
    {
        return !isWeekend();
    }

    public String toString(char delim)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delim, m_mon, delim, m_year);
    }

    public String toString()
    {
        return toString('/');
    }

    public String toStringTR()
    {
        return toStringTR('/');
    }

    public String toStringTR(char delim)
    {
        return String.format("%s %s", toString(delim), getDayOfWeekTR());
    }

    public String toStringEN()
    {
        return toStringEN('/');
    }

    public String toStringEN(char delim)
    {
        return String.format("%s %s", toString(delim), getDayOfWeekEN());
    }

    public String toLongDateStringTR()
    {
        return String.format("%02d %s %04d %s", getDay(), ms_monthsOfYearTR[getMonthValue()],getYear(), getDayOfWeekTR());
    }
    public String toLongDateStringEN()
    {
        return String.format("%02d%s %s %04d %s",getDay(), postFixForDay(m_day), ms_monthsOfYearEN[getMonthValue()], getYear(), getDayOfWeekEN());

    }
}
