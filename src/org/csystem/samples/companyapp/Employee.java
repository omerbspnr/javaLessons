package org.csystem.samples.companyapp;

public abstract class Employee {
    private String m_citizenId;
    private String m_name;
    //...

    protected Employee(String citizenId, String name)
    {
        m_citizenId = citizenId;
        m_name = name;
    }

    public String getCitizenId()
    {
        return m_citizenId;
    }

    public void setCitizenId(String citizenId)
    {
        m_citizenId = citizenId;
    }
    public  abstract double calculateInsurance();

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public String toString()
    {
        return String.format("[%s]%s", m_citizenId, m_name);
    }
}
