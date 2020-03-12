package org.csystem.util.datetime;

import java.util.Calendar;

public class Time {
    private int m_hour, m_minute, m_second, m_millisecond;

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1);

    }
    private static boolean isValidForVal(int val, int min, int max)
    {
        return val >= min && val <= max;
    }
    private static boolean isValidForTime(int hour, int minute, int second, int millisecond)
    {
        return isValidForHour(hour) && isValidForMinute(minute) && isValidForSecond(second) && isValidForMillisecond(millisecond);
    }
    private static boolean isValidForHour(int hour)
    {
        return isValidForVal(hour,0,23);
    }
    private static boolean isValidForMinute(int minute)
    {
      return  isValidForVal(minute,0,59);
    }
    private static boolean isValidForSecond(int second)
    {
        return isValidForVal(second,0,59);
    }
    private static boolean isValidForMillisecond(int millisecond)
    {
        return isValidForVal(millisecond,0,999);
    }

    private static void control(int hour,int minute, int second, int millisecond)
    {
        if(!isValidForTime(hour,minute,second,millisecond))
                doWorkForException("Invalid Time");
    }
    private static void controlForHour(int hour)
    {
        if (!isValidForHour(hour))
            doWorkForException("Invalid Hour");

    }
    private static void controlForMinute(int minute)
    {
        if(!isValidForMinute(minute))
            doWorkForException("Invalid Minute");

    }
    private static void controlForSecond(int second)
    {
        if(!isValidForSecond(second))
            doWorkForException("Invalid Second");

    }
    private static void controlForMillisecond(int millisecond)
    {
        if(!isValidForMillisecond(millisecond))
            doWorkForException("Invalid millisecond");

    }
    private  static boolean isEqual(int val, int val2)
    {
        return val == val2;
    }
    private void set(int hour, int minute, int second, int millisecond)
    {
        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;

    }
    public Time()
    {
        Calendar now = Calendar.getInstance();
        set(now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND), now.get(Calendar.MILLISECOND));
    }
    public Time(int hour,int minute, int second, int millisecond)
    {
        control(hour,minute,second,millisecond);
        set(hour,minute,second,millisecond);

    }

    public void setHour(int hour) {
        if (hour == m_hour)
            return;
        controlForHour(hour);
        m_hour = hour;
    }

    public void setMinute(int minute) {
        if (minute == m_minute)
            return;
        controlForMinute(minute);
        m_minute = minute;
    }

    public void setSecond(int second)
    {
        if(second == m_second)
            return;
        controlForSecond(second);
        m_second = second;
    }

    public void setMillisecond(int millisecond)
    {
        if(millisecond == m_millisecond)
            return;
        controlForMillisecond(millisecond);

        m_millisecond = millisecond;
    }

    public int getHour() {
        return m_hour;
    }

    public int getMinute() {
        return m_minute;
    }

    public int getSecond() {
        return m_second;
    }

    public int getMillisecond() {
        return m_millisecond;
    }

    public  int compateTo( Time rhs) {
        if (!isEqual(m_hour, rhs.m_hour))
            return m_hour - rhs.m_hour;

        if (!isEqual(m_minute, rhs.m_minute))
            return m_minute - rhs.m_minute;

        if (!isEqual(m_second, rhs.m_second))
            return m_second - rhs.m_second;

        return m_millisecond - rhs.m_millisecond;
    }
    public boolean isGreater(Time rhs)
    {
        return compateTo(rhs) > 0;
    }
    public boolean isLess(Time rhs)
    {
        return !isGreater(rhs);
    }

    public String toString()
    {
        return String.format("%s:%02d",toShortString(),m_second);

    }
    public String toShortString()
    {
        return String.format("%02d:%02d",m_hour,m_minute);
    }
    public String toLongString()
    {
        return String.format("%s:%04d",toString(),m_millisecond);
    }
}
