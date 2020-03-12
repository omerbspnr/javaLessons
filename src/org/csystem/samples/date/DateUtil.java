package org.csystem.samples.date;

public class DateUtil {
	public static int [] daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static String [] weekDaysTR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
	public static String [] weekDaysEN = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

	public static void displayDateTR(int day, int mon, int year)
	{
		int dayOfWeek = getDayOfWeek(day, mon, year);

		if (dayOfWeek == -1) {
			System.out.println("Geçersiz tarih");
			return;
		}

		System.out.printf("%02d/%02d/%04d %s%n", day, mon, year, weekDaysTR[dayOfWeek]);

		if (isWeekend(day, mon, year))
			System.out.println("Bugün kurs günü. Tekrar yaptın mı?");
		else
			System.out.println("Hafta içi takrar yapınız!!!");

	}

	public static void displayDateEN(int day, int mon, int year)
	{
		int dayOfWeek = getDayOfWeek(day, mon, year);

		if (dayOfWeek == -1) {
			System.out.println("Invalid date");
			return;
		}

		System.out.printf("%02d/%02d/%04d %s%n", day, mon, year, weekDaysEN[dayOfWeek]);

	}

	public static boolean isWeekend(int day, int mon, int year)
	{
		int dayOfWeek = getDayOfWeek(day, mon, year);

		return dayOfWeek == 0 || dayOfWeek == 6;
	}

	public static boolean isWeekday(int day, int mon, int year)
	{
		if (!isValidDate(day, mon, year))
			return false;

		return !isWeekend(day, mon, year);
	}

	public static int getDayOfWeek(int day, int mon, int year)
	{
		int totalDays = getDayOfYear(day, mon, year);

		if (totalDays == -1 || year < 1900)
			return -1;

		for (int y = 1900; y < year; ++y)
			totalDays += isLeapYear(y) ? 366 : 365;

		return totalDays % 7;
	}

	public static int getDayOfYear(int day, int mon, int year)
	{
		if (!isValidDate(day, mon, year))
			return -1;

		int dayOfYear = day;

		for (int m = mon - 1; m >= 1; --m)
			dayOfYear += daysOfMonths[m];

		if (mon > 2 && isLeapYear(year))
			++dayOfYear;

		return dayOfYear;
	}

	public static boolean isValidDate(int day, int mon, int year)
	{
		if (day < 1 || day > 31 || mon < 1 || mon > 12)
			return false;

		int days = isLeapYear(year) && mon == 2 ? 29 : daysOfMonths[mon];

		return day <= days;
	}

	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
