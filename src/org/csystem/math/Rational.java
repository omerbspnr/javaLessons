package org.csystem.math;

import org.csystem.util.NumberUtil;

import java.util.Random;

public class Rational {
    private int m_a, m_b;

    private static double ms_coefficientNumber = 1_000_000;

    private static Rational plus(int a1, int b1, int a2, int b2)
    {

        return new Rational(a1 * b2 + a2 * b1, b1 *b2);
    }
    private static Rational minus(int a1, int b1, int a2, int b2)
    {

        return plus(a1,b1, -a2, b2);
    }
    private static Rational multiply(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * a2, b1 * b2 );
    }
    private static Rational division(int a1, int b1, int a2, int b2)
    {
        return multiply(a1, b1,b2,a2);
    }

    private static void control(int a, int b)
    {
        if (b == 0) {
            System.out.println(a == 0 ?  "Tanımsız" : "Belirsiz");
            System.exit(-1);
        }
    }


    public static Rational getRandomRationalNumber()
    {
        return getRandomRationalNumber(new Random());
    }
    public static Rational getRandomRationalNumber(Random r)
    {
        return getRandomRationalNumber(r, -10_000,10_000);
    }
    public static Rational getRandomRationalNumber(int minBound, int maxBound)
    {

        return  getRandomRationalNumber(new Random(), minBound, maxBound);
    }
    public static Rational getRandomRationalNumber(Random r, int minBound, int maxBound)
    {


        return new Rational(r.nextInt(maxBound - minBound) + minBound, r.nextInt(maxBound - minBound) + minBound );
    }
    private  void simplify()
    {

        int a = Math.abs(m_a);
        int b = m_b;

        int min = a < b ? a : b;

        for (int i = min; i >= 2; --i) {
            if (a % i == 0 && b % i == 0) {
                m_a /= i;
                m_b /= i;
                break;
            }
        }
    }
    private void changeMinus()
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
        changeMinus();
        simplify();

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
    public Rational(double d)
    {
        int a  = (int)(d * ms_coefficientNumber);
        int b = a == 0 ? 1 : (int)ms_coefficientNumber;
        set(a, b);
    }

    /*
     plus methods
     */

    public Rational plus(int val)
    {

        return plus(m_a, m_b, val, 1);
    }

    public Rational plus(Rational r1)
    {

        return plus(m_a, m_b, r1.m_a, r1.m_b);
    }
    public static Rational plus(int val, Rational r1)
    {
        return plus(val, 1, r1.m_a,r1.m_b);
    }
    /*
     Minus methods
     */

    public Rational minus(int val)
    {

        return minus(m_a,m_b,val,1);
    }
    public Rational minus(Rational r1)
    {

        return minus(m_a,m_b,r1.m_a,r1.m_b);
    }
    public static Rational minus(int val, Rational r1)
    {
        return minus(val, 1, r1.m_a, r1.m_b);
    }


    /*
     Multiply methods
     */
    public Rational multiply(int val)
    {
        return multiply(m_a, m_b, val, 1);
    }
    public Rational multiply(Rational r1)
    {
        return multiply(m_a,m_b,r1.m_a,r1.m_b);
    }
    public static Rational multiply(int val, Rational r1)
    {
        return multiply(val, 1, r1.m_a, r1.m_b);
    }

    /*

     Division methods

    */

    public Rational division(int val)
    {
        return division(m_a, m_b, val, 1);
    }
    public Rational division(Rational r1)
    {
        return division(m_a,m_b,r1.m_a,r1.m_b);
    }
    public static Rational division(int val, Rational r1)
    {
        return division(val, 1, r1.m_a, r1.m_b);
    }
    public void inc()
    {
     inc(1);
    }
    public void inc(int amount)
    {
        this.m_a += amount * m_b;
    }
    public void dec()
    {
        dec(1);
    }
    public void dec(int amount)
    {
        inc(-amount);
    }
    public void pow(int n)
    {
            m_a = (int)Math.pow(m_a,n);
            m_b = (int)Math.pow(m_b,n);
    }

    public void setNumerator(int a)
    {
        if (a == m_a)
            return;
        set(a,m_b);
    }
    public void setDenominator(int b)
    {
        if (m_b == b)
            return;
        control(m_a,b);
        set(m_a,b);
    }
    public int getNumerator()
    {
        return m_a;
    }

    public int getDenominator ()
    {
        return m_b;
    }
    public double getRealValue()
    {
        return (double) m_a / m_b;
    }
    public int compareTo(Rational r1) {
        return m_a * r1.m_b - m_b * r1.m_a;

    }
    public String toString() {
        return toString(6);
    }
    public String toString(int n) {
        String fmt = String.format("%%d / %%d = %%.%df",n);

        return String.format(fmt,m_a,m_b);
    }
}
