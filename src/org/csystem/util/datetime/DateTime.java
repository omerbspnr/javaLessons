package org.csystem.util.datetime;

public class DateTime {
    private Date m_date;
    private Time m_time;

    public DateTime()
    {
        m_date = new Date();
        m_time = new Time();

    }

    public DateTime(Date date)
    {
        this(date, 0);
    }
    public DateTime(Date date, int hour)
    {
        this(date, hour, 0);

    }
    public DateTime(Date date, int hour, int minute)
    {
        this(date, hour, minute, 0 );

    }
    public DateTime(Date date, int hour, int minute, int second)
    {
        this(date, hour, minute,second, 0);

    }
    public DateTime(Date date, int hour, int minute, int second, int millisecond)
    {
        m_date = new Date(date);
        m_time = new Time(hour, minute, second, millisecond);
    }

    public DateTime(Date date,Time time)
    {
        m_date = new Date(date);
        m_time = new Time(time);

    }

    public DateTime(int year)
    {
        this(0,year);
    }
    public DateTime(int mon, int year)
    {
        this(0, mon,year);
    }
    public DateTime(int day ,int mon, int year)
    {
        this(day, mon ,year, 0);
    }
    public DateTime(int day ,int mon, int year, int hour)
    {
        this(day, mon ,year, hour, 0);
    }
    public DateTime(int day ,int mon, int year, int hour, int minute)
    {
        this(day, mon ,year, hour, minute, 0);
    }
    public DateTime(int day ,int mon, int year, int hour, int minute, int second)
    {
        this(day, mon ,year, hour, minute, second, 0);
    }
    public DateTime(int day ,int mon, int year, int hour, int minute, int second, int millisecond)
    {
        m_date = new Date(day, mon, year);
        m_time = new Time(hour, minute, second, millisecond);
    }

    public DateTime(Month month, int year)
    {
        this(0, month, year);
    }
    public DateTime(int day ,Month month, int year)
    {
        this(day, month, year, 0);
    }
    public DateTime(int day ,Month month, int year, int hour)
    {
        this(day, month, year, hour, 0);
    }
    public DateTime(int day ,Month month, int year, int hour, int minute)
    {
        this(day, month, year, hour, minute, 0);
    }
    public DateTime(int day ,Month month, int year, int hour, int minute, int second)
    {
        this(day, month, year, hour, minute, second, 0);
    }
    public DateTime(int day ,Month month, int year, int hour, int minute, int second, int millisecond)
    {
        this (day, month.ordinal() + 1, year, hour, minute, second, millisecond);
    }

}
