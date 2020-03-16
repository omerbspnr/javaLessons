package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class myDate {
    private static final String [] ms_weekDaysTR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
    private static final String [] ms_weekDaysEN = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    private int m_day, m_mon,m_year;
    private int m_dayOfWeek;
    private static int getDayOfWeek(int day, int mon, int year)
    {
        int totalDays = getDayOfYear(day, mon, year);
        for (int i = 1900; i < year; ++i)
            totalDays += myMonth.isLeapYear(year) ? 366 : 365;

        return totalDays;
    }
    private static int getDayOfYear(int day, int mon, int year)
    {
        int dayOfYear = day;

        for (int i = 0; i < mon; ++i) {
            dayOfYear += myMonth.values()[i].getDaysByYear(year);
        }

        return dayOfYear;
    }
    private static boolean isvalidDate(int day, int mon, int year)
    {
        if (mon < 1 || mon > 12 || day < 1 || day > 31)
            return false;

        int days = myMonth.values()[mon- 1].getDaysByYear(year);

        return day <= days;
    }

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1);
    }

    private static void control(int day, int mon, int year, String msg)
    {
        if (!isvalidDate(day, mon, year))
            doWorkForException(msg);
    }
    private  void controlForDay(int day) { control(day,m_mon,m_year,"Invalid Day");}
    private  void controlForMon(int mon) {control(m_day,mon,m_year, "Invalid Month");}
    private  void controlForYear(int year){control(m_day,m_mon, year,"Invalid Year");}

    private void set(int day, int mon, int year)
    {
        m_day = day;
        m_mon = mon;
        m_year = year;
        m_dayOfWeek = getDayOfWeek(day, mon, year);
    }

    public static Date randomDate()
    {
        return randomDate(new Random());
    }
    public static Date randomDate(Random r)
    {
        Date now = new Date();

        return randomDate(r, now.getYear(), now.getYear());
    }

    public static Date randomDate(int year)
    {
        return randomDate(new Random(), year);
    }
    public static Date randomDate( Random r,int year)
    {
        return randomDate(r,year,year);
    }
    public static Date randomDate(Random r, int minYear, int maxYear)
    {
        int year = r.nextInt(maxYear - minYear + 1) + minYear;
        int mon = r.nextInt(myMonth.values().length);

        int day = r.nextInt(myMonth.values()[mon - 1].getDaysByYear(year)) + 1;

        return new Date(day, mon, year);

    }

    public myDate()
    {
        Calendar now = Calendar.getInstance();

        set(now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH)+ 1, now.get(Calendar.YEAR));
    }
    public myDate(int day, int mon, int year)
    {
        control(day, mon, year, "Invalid Date");
    }
    public myDate(int day, myMonth mon, int year)
    {
        control(day, mon.ordinal() + 1, year, "Invalid Date");

    }

    public void setDay(int day)
    {
        if (day == m_day)
            return;

        controlForDay(day);
        set(day,m_mon,m_year);
    }

    public void setMonthValue(int mon)
    {
        if (mon == m_mon)
            return;

        controlForMon(mon);
        set(m_day, mon, m_year);
    }
    public void setMonth(myMonth mon)
    {
        setMonthValue(mon.ordinal() + 1);
    }
    public void setYear(int year)
    {
        controlForYear(year);
        set(m_day,m_mon,year);
    }

    public int getDay() { return m_day; }

    public int getMonthValue() { return m_mon; }
    public myMonth getMonth() {return myMonth.values()[m_dayOfWeek];}
    public int getYear() { return m_year; }
    public myDayOfWeek getDayOfWeek()
    {
        return  myDayOfWeek.values()[m_dayOfWeek];
    }
    public int getDayOfWeekValue()
    {
        return m_dayOfWeek;
    }
    public int getDayOfyear()
    {
        return getDayOfYear(m_day, m_mon, m_year);
    }

    public String toString()
    {
        return String.format("%02d/%02d/%04d", m_day,m_mon,m_year);

    }
}
