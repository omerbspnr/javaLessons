package org.csystem.samples.companyapp;

public class Worker extends Employee {
    private double m_feePerHour;
    private int m_hourPerDay;

    //...
    public Worker(String citizenId, String name, double feePerHour, int hourPerDay)
    {
        super(citizenId, name);
        m_feePerHour = feePerHour;
        m_hourPerDay = hourPerDay;
    }

    public double getFeePerHour()
    {
        return m_feePerHour;
    }

    public void setFeePerHour(double feePerHour)
    {
        m_feePerHour = feePerHour;
    }

    public int getHourPerDay()
    {
        return m_hourPerDay;
    }

    public void setHourPerDay(int hourPerDay)
    {
        m_hourPerDay = hourPerDay;
    }

    public double calculateInsurance()
    {
        return m_feePerHour * m_hourPerDay * 30;
    }

    public String toString()
    {
        return String.format("%s:%f", super.toString(), m_feePerHour * m_hourPerDay);
    }
}
