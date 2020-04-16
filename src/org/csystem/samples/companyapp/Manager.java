package org.csystem.samples.companyapp;

public class Manager extends Employee {
    private double m_salary;
    private String m_departmentName;

    public Manager(String citizenId, String name, double salary, String departmentName)
    {
        super(citizenId, name);
        m_salary = salary;
        m_departmentName = departmentName;
    }

    public double getSalary()
    {
        return m_salary;
    }

    public void setSalary(double salary)
    {
        m_salary = salary;
    }

    public String getDepartmentName()
    {
        return m_departmentName;
    }

    public double calculateInsurance()
    {
        return m_salary * 8 / 100;
    }

    public void setDepartmentName(String departmentName)
    {
        m_departmentName = departmentName;
    }

    public String toString()
    {
        return String.format("%s:%s:%s", m_departmentName, m_salary, super.toString());
    }
}
