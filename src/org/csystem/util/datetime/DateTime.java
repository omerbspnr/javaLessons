/*----------------------------------------------------------------------------------------------------------------------
    DateTime sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

public class DateTime {
    private Date m_date;
    private Time m_time;

    //...

    public DateTime(Date date, Time time)
    {
        m_date = new Date(date.getDay(), date.getMonth(), date.getYear());
        m_time = new Time(time.getHour(), time.getMinute(), time.getSecond());
    }

    public Date getDate()
    {
        return m_date;
    }

    public void setDate(Date date)
    {
        m_date = date;
    }

    public Time getTime()
    {
        return m_time;
    }

    public void setTime(Time time)
    {
        m_time = time;
    }

    public String toString()
    {
        return String.format("%s %s", m_date.toString(), m_time.toString());
    }
}
