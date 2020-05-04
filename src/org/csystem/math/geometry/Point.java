/*----------------------------------------------------------------------------------------------------------------------	
	Point sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class Point {
	public int x, y;

	Point(Point p)
	{
		x = p.x;
		y = p.y;
	}

	public Point()
	{}

	public Point(int x)
	{
		this(x, 0);
	}
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double distance()
	{
		return this.distance(0, 0);
	}
	
	public double distance(Point p)
	{
		return this.distance(p.x, p.y);
	}
	
	public double distance(int a, int b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));
	}
	
	public void offset(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	public void offset(int dxy)
	{
		this.offset(dxy, dxy);
	}


	public String toString()
	{		
		return String.format("(%d, %d)", x, y);
	}
}
