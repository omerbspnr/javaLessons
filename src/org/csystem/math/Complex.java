/*----------------------------------------------------------------------------------------------------------------------
	Complex sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

import static java.lang.Math.sqrt;

public class Complex {
	private static Complex minus(double a1, double b1, double a2, double b2) //ileride bu metot gizlenecek
	{
		return plus(a1, b1, -a2, -b2);
		// bu metotların gizlenmesinin nedeni elimizde en az bir tane Complex sınıfı olması gerektiğindendir.
	}

	private  static Complex plus(double a1, double b1, double a2, double b2) //ileride bu metot gizlenecek
	{
		return new Complex(a1 + a2, b1 + b2);
		// bu metotların gizlenmesinin nedeni elimizde en az bir tane Complex sınıfı olması gerektiğindendir.
	}


	public double a, b;

	public Complex() {}

	public Complex(double re)
	{
		a = re;
	}

	public Complex(double re, double im)
	{
		a = re;
		b = im;
	}

	public double getNorm() {return sqrt(a * a + b * b);}

	public Complex getConjugate() {return new Complex(a, -b);}

	//plus methods

	public static Complex plus(double val, Complex z)
	{
		return plus(val, 0, z.a, z.b);
	}

	public Complex plus(Complex z)
	{
		return plus(a, b, z.a, z.b);
	}

	public Complex plus(double val)
	{
		return plus(a, b, val, 0);
	}

	//minus methods

	public static Complex minus(double val, Complex z)
	{
		return minus(val, 0, z.a, z.b);
	}

	public Complex minus(Complex z)
	{
		return minus(a, b, z.a, z.b);
	}

	public Complex minus(double val)
	{
		return minus(a, b, val, 0);
	}

	//inc methods

	public void inc()
	{
		inc(1);
	}

	public void inc(int amount)
	{
		a += amount;
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

	public String toString()
	{
		return String.format("|%.2f + %.2fi|=%f", a, b, getNorm());
	}
}