package org.csystem.util.datetime;

public class DateTime {
    private Date m_date;
    private Time m_time;

    public static class Builder {
        private Date m_date = null;
        private Time m_time = new Time(0);
        public Builder() { }
        public DateTime.Builder setDate(int day, int mon, int year)
        {
            m_date = new Date(day, mon, year);
            return  this;
        }
        public Builder setDate(int day, Month mon, int year)
        {
            return this.setDate(day, mon.ordinal() + 1, year);
        }
        public Builder setDateTime(Date date, Time time)
        {
            m_date = new Date(date);
            m_time = new Time();
            return this;
        }
        public Builder setHour(int hour)
        {
            m_time.setHour(hour);
            return this;
        }
        public Builder setMinute(int minute)
        {
            m_time.setMinute(minute);
            return this;
        }
        public Builder setSecond(int second)
        {
            m_time.setSecond(second);
            return this;
        }
        public Builder setMillisecond(int millisecond)
        {
            m_time.setMillisecond(millisecond);
            return this;
        }
        public Builder setTime(Time time)
        {
            m_time = new Time(time);
            return this;
        }
        public DateTime build()
        {
            return new DateTime(m_date, m_time);
        }

    }
    public DateTime()
    {
        this(new Date(), new Time());
    }
    private DateTime(Date date,Time time)
    {
        m_date = date == null ? new Date() : date;
        m_time = time == null ? new Time(0) : time;

    }

    private DateTime(Date date)
    {
        this(date, 0);
    }
    private DateTime(Date date, int hour)
    {
        this(date, hour, 0);

    }
    private DateTime(Date date, int hour, int minute)
    {
        this(date, hour, minute, 0 );

    }
    private DateTime(Date date, int hour, int minute, int second)
    {
        this(date, hour, minute,second, 0);

    }
    private DateTime(Date date, int hour, int minute, int second, int millisecond)
    {
        m_date = new Date(date);
        m_time = new Time(hour, minute, second, millisecond);
    }


    private DateTime(int year)
    {
        this(1,year);
    }
    private DateTime(int mon, int year)
    {
        this(1, mon,year);
    }
    private DateTime(int day ,int mon, int year)
    {
        this(day, mon ,year, 0);
    }
    private DateTime(int day ,int mon, int year, int hour)
    {
        this(day, mon ,year, hour, 0);
    }
    private DateTime(int day ,int mon, int year, int hour, int minute)
    {
        this(day, mon ,year, hour, minute, 0);
    }
    private DateTime(int day ,int mon, int year, int hour, int minute, int second)
    {
        this(day, mon ,year, hour, minute, second, 0);
    }
    private DateTime(int day ,int mon, int year, int hour, int minute, int second, int millisecond)
    {
        m_date = new Date(day, mon, year);
        m_time = new Time(hour, minute, second, millisecond);
    }

    private DateTime(Month month, int year)
    {
        this(0, month, year);
    }
    private DateTime(int day ,Month month, int year)
    {
        this(day, month, year, 0);
    }
    private DateTime(int day ,Month month, int year, int hour)
    {
        this(day, month, year, hour, 0);
    }
    private DateTime(int day ,Month month, int year, int hour, int minute)
    {
        this(day, month, year, hour, minute, 0);
    }
    private DateTime(int day ,Month month, int year, int hour, int minute, int second)
    {
        this(day, month, year, hour, minute, second, 0);
    }
    private DateTime(int day ,Month month, int year, int hour, int minute, int second, int millisecond)
    {
        this (day, month.ordinal() + 1, year, hour, minute, second, millisecond);
    }
    public String toString()
    {
        return String.format("%s %s",m_date.toString(), m_time.toLongTimeString());
    }
}
