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

	public Point(int a)
	{
		x = a;
	}
	
	public Point(int a, int b)
	{
		x = a;
		y = b;
	}
	
	public double distance()
	{
		return distance(0, 0);		
	}
	
	public double distance(Point p)
	{
		return distance(p.x, p.y);
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
		offset(dxy, dxy);
	}
	
	public String toString()
	{		
		return String.format("(%d, %d)", x, y);
	}
}
