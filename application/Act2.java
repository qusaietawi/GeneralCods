package application;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Act2 {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();		

		// set date to the first day in a month
		calendar.set(Calendar.DATE, 1);

		// print calendar for the month
		printMonth(calendar);
	}

	static void printMonth(GregorianCalendar calendar) {
		// get start day of the week for the first date in the month
		int startDay = getStartDay(calendar);		
		
		// get number of days in the month
		int numOfDaysInMonth = daysInMonth(calendar);

		// print headings
		printMonthTitle(calendar);

		// print body
		printMonthBody(startDay, numOfDaysInMonth);
	}

	static int getStartDay(GregorianCalendar calendar) {
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	static void printMonthBody(int startDay, int numOfDaysInMonth) {
		// print padding space before the first day of the month
		int i = 0;
		for (i = 0; i < startDay - 1; i++)
			System.out.print("    ");

		for (i = 1; i <= numOfDaysInMonth; i++) {
			if (i < 10)
				System.out.print("   " + i);
			else
				System.out.print("  " + i);

			if ((i + startDay - 1) % 7 == 0)
				System.out.println();
		}
		System.out.println("");
	}

	static void printMonthTitle(GregorianCalendar calendar) {
		System.out.println("         " + getMonthName(calendar) + " " + calendar.get(Calendar.YEAR));
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	public static int daysInMonth(GregorianCalendar calendar) {
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

	}

	/** return month name in English */
	public static String getMonthName(GregorianCalendar calendar) {
		String[] monthNames = new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		return monthNames[calendar.get(Calendar.MONTH)];
	}
}