/*----------------------------------------------------------------------------------------------------------------------
    Circle sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class Circle {
    private double m_r;

    public Circle()
    {}

    public Circle(double r)
    {
        this.setRadius(r);
    }

    public final void setRadius(double r)
    {
        if (m_r == r)
            return;

        m_r = Math.abs(r);
    }

    public final double getRadius() {return m_r;}
    public final double getArea() {return Math.PI * m_r * m_r;}
    public final double getCircumference() {return 2 * Math.PI * m_r;}
}
