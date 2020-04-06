/*----------------------------------------------------------------------------------------------------------------------
    Time sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Time {
    private int m_hour, m_minute, m_second, m_millisecond;

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1); //exception işlemlerine kadar sabredin
    }

    private static boolean isValidForBounds(int val, int min, int max)
    {
        return min <= val && val <= max;
    }

    private static boolean isValidForTime(int hour, int minute, int second, int millisecond)
    {
        return isValidForHour(hour) && isValidForMinute(minute) && isValidForSecond(second)
                && isValidForMillisecond(millisecond);
    }

    private static boolean isValidForHour(int val)
    {
        return isValidForBounds(val, 0, 23);
    }

    private static boolean isValidForMinute(int val)
    {
        return isValidForBounds(val, 0, 59);
    }

    private static boolean isValidForSecond(int val)
    {
        return isValidForBounds(val, 0, 59);
    }

    private static boolean isValidForMillisecond(int val)
    {
        return isValidForBounds(val, 0, 999);
    }

    private static void control(int hour, int minute, int second, int millisecond)
    {
        if (!isValidForTime(hour, minute, second, millisecond))
            doWorkForException("Invalid time");
    }

    private static void controlForHour(int val)
    {
        if (!isValidForHour(val))
            doWorkForException("Invalid hour");
    }

    private static void controlForMinute(int val)
    {
        if (!isValidForMinute(val))
            doWorkForException("Invalid minute");
    }

    private static void controlForSecond(int val)
    {
        if (!isValidForSecond(val))
            doWorkForException("Invalid second");
    }

    private static void controlForMillisecond(int val)
    {
        if (!isValidForMillisecond(val))
            doWorkForException("Invalid millisecond");
    }

    private void set(int hour, int minute, int second, int millisecond)
    {
        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;
    }

    public static Time randomTime()
    {
        return randomTime(new Random());
    }

    public static Time randomTime(Random r)
    {
        return new Time(r.nextInt(24), r.nextInt(60), r.nextInt(60), r.nextInt(1000));
    }
    public static class TimeBuilder
    {
        private Time m_time;

        public TimeBuilder() {
            m_time = new Time(0);
        }

        public TimeBuilder setHour(int hour)
        {
            this.m_time.setHour(hour);
            return this;
        }
        public TimeBuilder setMinute(int minute)
        {
            this.m_time.setMinute(minute);
            return this;
        }
        public TimeBuilder setSecond(int second)
        {
            this.m_time.setSecond(second);
            return this;
        }
        public TimeBuilder setMillisecond(int millisecond)
        {
            this.m_time.setMillisecond(millisecond);
            return this;
        }

        public Time build()
        {
            return m_time;
        }
    }
    Time(Time other)
    {
        m_hour = other.m_hour;
        m_minute = other.m_minute;
        m_second = other.m_second;
        m_millisecond = other.m_millisecond;
    }

    public Time() //Bu kısmın detayları önemsiz
    {
        Calendar now = Calendar.getInstance();

        set(now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND), now.get(Calendar.MILLISECOND));
    }
    public Time(int hour)
    {
        this(hour, 0);
    }

    public Time(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second)
    {
        this(hour, minute, second, 0);
    }

    public Time(int hour, int minute, int second, int millisecond)
    {
        control(hour, minute, second, millisecond);
        set(hour, minute, second, millisecond);
    }

    public void setHour(int hour)
    {
        if (hour == m_hour)
            return;

        controlForHour(hour);
        m_hour = hour;
    }

    public void setMinute(int minute)
    {
        if (minute == m_minute)
            return;

        controlForMinute(minute);
        m_minute = minute;
    }

    public void setSecond(int second)
    {
        if (second == m_second)
            return;

        controlForSecond(second);
        m_second = second;
    }

    public void setMillisecond(int millisecond)
    {
        if (millisecond == m_millisecond)
            return;

        controlForMillisecond(millisecond);
        m_millisecond = millisecond;
    }

    public int getHour()
    {
        return m_hour;
    }

    public int getMinute()
    {
        return m_minute;
    }

    public int getSecond()
    {
        return m_second;
    }

    public int getMillisecond()
    {
        return m_millisecond;
    }

    public String toString()
    {
        return String.format("%s:%02d", toShortTimeString(), m_second);
    }

    public String toShortTimeString()
    {
        return String.format("%02d:%02d", m_hour, m_minute);
    }

    public String toLongTimeString()
    {
        return String.format("%s.%03d", toString(), m_millisecond);
    }
}
