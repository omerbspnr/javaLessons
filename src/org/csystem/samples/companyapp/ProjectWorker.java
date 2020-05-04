package org.csystem.samples.companyapp;

public class ProjectWorker extends Worker {
    private String m_projectName;

    public ProjectWorker(String citizenId, String name, double feePerHour, int hourPerDay, String projectName)
    {
        super(citizenId, name, feePerHour, hourPerDay);
        m_projectName = projectName;
    }

    public String getProjectName()
    {
        return m_projectName;
    }

    public void setProjectName(String projectName)
    {
        m_projectName = projectName;
    }

    public double calculateInsurance()
    {
        return super.calculateInsurance() * 1.15;
    }

    public String toString()
    {
        return String.format("%s:%s", m_projectName, super.toString());
    }
}
