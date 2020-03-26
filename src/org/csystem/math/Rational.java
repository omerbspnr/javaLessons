/*----------------------------------------------------------------------------------------------------------------------
    Rational sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

import java.util.Random;

public final class Rational {
    private int m_a, m_b;

    private static Rational plus(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * b2 + a2 * b1, b1 * b2);
    }

    private static Rational minus(int a1, int b1, int a2, int b2)
    {
        return plus(a1, b1, -a2, b2);
    }

    private static Rational multiply(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * a2, b1 * b2);
    }

    private static Rational div(int a1, int b1, int a2, int b2)
    {
        return multiply(a1, b1, b2, a2);
    }

    private static void control(int a, int b)
    {
        if (b == 0) {
            System.out.println(a == 0 ? "Belirsiz" : "Tanımsız");
            System.exit(-1); //exception konusuna sabredin
        }
    }

    private void calibrateSigns()
    {
        if (m_b < 0) {
            m_a *= -1;
            m_b *= -1;
        }
    }

    private void set(int a, int b)
    {
        m_a = a;
        if (m_a == 0) {
            m_b = 1;
            return;
        }

        m_b = b;
        calibrateSigns();
        simplify();
    }

    private void simplify()
    {
        int a = Math.abs(m_a);
        int b = m_b;

        int min = a > b ? b : a;

        for (int i = min; i >= 2; --i) {
            if (a % i == 0 && b % i == 0) {
                m_a /= i;
                m_b /= i;
                break;
            }
        }
    }

    public static Rational randomRational(int min, int max) //[min, max)
    {
        return randomRational(new Random(), min, max);
    }

    public static Rational randomRational(Random r, int min, int max)  //[min, max)
    {
        return new Rational(r.nextInt(max - min) + min, r.nextInt(max - min) + min);
    }

    public Rational()
    {
        m_b = 1;
    }

    public Rational(int a, int b)
    {
        control(a, b);
        set(a, b);
    }

    public void setNumerator(int val)
    {
        if (m_a == val)
            return;

        set(val, m_b);
    }

    public void setDenominator(int val)
    {
        if (m_b == val)
            return;

        control(m_a, val);
        set(m_a, val);
    }

    public int getNumerator()
    {
        return m_a;
    }

    public int getDenominator()
    {
        return m_b;
    }

    public double toDouble()
    {
        return (double)m_a / m_b;
    }

    //plus methods
    public static Rational plus(int val, Rational r)
    {
        return plus(val, 1, r.m_a, r.m_b);
    }

    public Rational plus(Rational r)
    {
        return plus(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational plus(int val)
    {
        return plus(m_a, m_b, val, 1);
    }

    //minus methods
    public static Rational minus(int val, Rational r)
    {
        return minus(val, 1, r.m_a, r.m_b);
    }

    public Rational minus(Rational r)
    {
        return minus(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational minus(int val)
    {
        return minus(m_a, m_b, val, 1);
    }

    //multiply methods
    public static Rational multiply(int val, Rational r)
    {
        return multiply(val, 1, r.m_a, r.m_b);
    }

    public Rational multiply(Rational r)
    {
        return multiply(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational multiply(int val)
    {
        return multiply(m_a, m_b, val, 1);
    }

    //div methods
    public static Rational div(int val, Rational r)
    {
        return div(val, 1, r.m_a, r.m_b);
    }

    public Rational div(Rational r)
    {
        return div(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational div(int val)
    {
        return div(m_a, m_b, val, 1);
    }

    //inc methods
    public void inc()
    {
        inc(1);
    }
    public void inc(int amount)
    {
        m_a += amount * m_b;
    }

    //dec methods
    public void dec()
    {
        dec(1);
    }
    public void dec(int amount)
    {
        inc(-amount);
    }

    //pow method
    public void pow(int n)
    {
        m_a = (int)Math.pow(m_a, n);
        m_b = (int)Math.pow(m_b, n);
    }

    public int compareTo(Rational r)
    {
        return m_a * r.m_b - r.m_a * m_b;
    }

    public String toString()
    {
        return toString(6);
    }

    public String toString(int n)
    {
        String fmt = String.format("%%d / %%d = %%.%df", n);

        return String.format(fmt, m_a, m_b, toDouble());
    }
}
