package org.csystem.math.geometry;


public class Circle {
    private double m_r;
// int this class if we are calling getRadius and getCircumreference method we have to do it class member variable
    //private double m_Circumreference, m_area;

    public Circle()
    {}
    public Circle(double r)
    {
        setRadius(r);
    }
    public double getArea()
    {
        return  m_r * m_r * Math.PI;
    }

    public double getCircumrefence()
    {
        return  2 * Math.PI * m_r;
    }

    public double getRadius()
    {
        return  m_r;
    }
    public void setRadius(double r)
    {
        m_r = Math.abs(r);
    }




}
