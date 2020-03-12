package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Date {
    private static final int [] ms_daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String [] ms_weekDaysTR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
    private static final String [] ms_weekDaysEN = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    private static final String[] ms_monthsOfYearTR = {"","Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz",
            "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
    private static final String[] ms_monthsOfYearEN = {"","Jan", "Feb", "Mar", "Apr", "May","Jun","Jul","Aug", "Sep","Oct", "Nov", "Dec"};

    private int m_day, m_mon, m_year;
    private int m_dayOfWeek;

    private static boolean isValidDate(int day, int mon, int year)
    {
        if (day < 1 || day > 31 || mon < 1 || mon > 12)
            return false;
        int days = isLeapYear(year) && mon == 2 ? 29 : ms_daysOfMonths[mon];

        return day <= days;
    }
    private static int getDayOfYear(int day, int mon, int year)
    {
        int daysOfYear = day;
        for (int i = 1; i < mon; ++i)
            daysOfYear += ms_daysOfMonths[i];

        if  (mon > 2 && isLeapYear(year))
            ++daysOfYear;

        return daysOfYear;
    }
    private static int dayOfWeek(int day, int mon, int year)
    {
        int totaldays = getDayOfYear(day,mon,year);

        for (int i = 1900; i < year; ++i)
            totaldays += isLeapYear(i) ? 366 : 365;

        return totaldays % 7;
    }

    private static boolean isLeapYear(int year)
    {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }
    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1);
    }

    private String postFixForDay(int day)
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
    private static void control(int day, int mon, int year, String msg)
    {
        if (!isValidDate(day,mon,year)) {
            doWorkForException(msg);
        }
        
    }
    private  void controlForDay(int day)
    {
        control(day,m_mon,m_year,"Invalid Day");
    }
    private void  controlForMonValue(int mon)
    {
        control(m_day,mon,m_year,"Invalid Month");

    }
    private  void controlForYear(int year)
    {
        control(m_day,m_mon,year,"Invalid Year");

    }
    private void set(int day, int mon, int year)
    {
        m_day = day;
        m_mon = mon;
        m_year = year;

        m_dayOfWeek = dayOfWeek(m_day, m_mon, m_year);

    }

    public static Date getRandomDate()
    {
        return getRandomDate(new Random());
    }
    public static Date getRandomDate(Random r) {
        Date now = new Date();

        return getRandomDate(r,now.getYear(), now.getYear());
    }
    public static Date getRandomDate(int year) {
        return getRandomDate(new Random(),year);
    }
    public static Date getRandomDate(Random r, int year) {
        return getRandomDate(r,year,year);
    }

    public static Date getRandomDate(int minYear, int maxYear)
    {
        return getRandomDate(new Random(), minYear,maxYear);

    }
    public static Date getRandomDate(Random r, int minYear, int maxYear) {
        int year = r.nextInt(maxYear - minYear + 1) +minYear;

        int mon = r.nextInt(12) + 1;

        int day = r.nextInt(isLeapYear(year) && mon == 2 ?  29 : ms_daysOfMonths[mon]) + 1;

        return new Date(day,mon,year);
    }
    public Date()
    {
        Calendar now = Calendar.getInstance();

        set(now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1,  now.get(Calendar.YEAR));
    }
    public Date(int day, int mon, int year)
    {
        control(day,mon,year,"Invalid Date");
        set(day, mon, year);
    }

    public void setDay(int day)
    {
        if (day == m_day)
            return;
        controlForDay(day);
        m_day = day;
    }

    public void setMon(int mon)
    {
        if (mon == m_mon)
            return;
        controlForMonValue(mon);
        m_mon = mon;
    }

    public void setYear(int year)
    {
        if (year == m_year)
            return;
        controlForYear(year);
        m_year = year;
    }
    public int getDayOfWeekValue() {
        return m_dayOfWeek;
    }
    public int getDay() {
        return  m_day;
    }
    public int getMonthValue()
    {
        return m_mon;
    }
    public int getYear()
    {
        return m_year;
    }
    public String getDayOfWeekTR() {
        return ms_weekDaysTR[getDayOfWeekValue()];
    }

    public String getDayOfWeekEN() {
        return ms_weekDaysEN[getDayOfWeekValue()];
    }
    public int getDayOfYear()
    {
        return  getDayOfYear(m_day,m_mon,m_year);
    }
    public boolean isLeapYear()
    {
        return isLeapYear(m_year);
    }
    public boolean isWeekend()
    {
        return m_dayOfWeek == 0 || m_dayOfWeek == 6;
    }
    public  boolean isWeekDay()
    {
        return !isWeekend();
    }
    public String toString()
    {
        return toString('/');
    }
    public String toString(char delim)
    {
        return String.format("%02d%c%02d%c%04d",getDay(),delim,getMonthValue(),delim,getYear());
    }

    public String toStringTR()
    {
        return toStringTR('/');
    }
    public String toStringTR(char delim)
    {
        return String.format("%s %s", toString(delim), getDayOfWeekTR());
    }
    public String toStringEN() {
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