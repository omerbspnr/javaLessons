package org.csystem.samples.companyapp;

public class SalesManager extends Manager {
    private double m_extra;

    public SalesManager(String citizenId, String name, double salary, String departmentName, double extra)
    {
        super(citizenId, name, salary, departmentName);
        m_extra = extra;
    }

    public double getExtra()
    {
        return m_extra;
    }

    public void setExtra(double extra)
    {
        m_extra = extra;
    }

    public String toString()
    {
        return String.format("%s:%f", super.toString(), getSalary() +  m_extra);
    }
}
