package application;

import java.util.Scanner;

public class ScientificCalculator {

	public static void main(String[] args) {
		Scanner v = new Scanner(System.in);
		while (true) {
			System.out.println("Please enter your name:");
			String name = v.nextLine();

			System.out.println("Please enter a 9-digit ID number or -1 to end:");
			int id = v.nextInt();
			v.nextLine();

			if (id == -1) {
				System.out.println("Goodbye");
				v.close();
				return;
			}

			if (isValidID(id)) {
				System.out.println("ID is valid. Welcome, " + name);
				break;
			} else {
				System.out.println("Invalid ID, please try again or enter -1 to end.");
				continue;
			}
		}

		while (true) {
			System.out.println("\n Scientific Calculator Menu : ");
			System.out.println("1- Calculate Sine, Cosine, Tangent");
			System.out.println("2- Calculate Factorile");
			System.out.println("3- Decimal to Hexadecimal");
			System.out.println("4- Exit");
			int your_Choice = v.nextInt();
			switch (your_Choice) {
			case 1:
				System.out.println("Enter the angle in degrees:");
				double angle1 = v.nextDouble();
				calculateTrigFunction(angle1);
				break;

			case 2:
				System.out.println("Enter a positive integer to calculate factoriale");
				int Factorile1 = v.nextInt();
				if (Factorile1 < 0) {
					System.out.println("Invalid input plese try again and enter positive integer:");
				} else {
					System.out.println("Factorile of" + Factorile1 + "is" + calculateFactorile(Factorile1));

				}
				break;

			case 3:
				System.out.println("Enter positive integer to convert to hexadecimal:");
				int decimal22 = v.nextInt();
				if (decimal22 < 0) {
					System.out.println("Invalid input please try again and enter positve integer ");

				} else {
					System.out.println("Hexadecimal " + decimalToHex(decimal22));
				}
				break;
			case 4:
				System.out.println("Good Bye");
				v.close();
				return;

			default:
				System.out.println("Invalid choice please try again");

			}
		}

	}

	public static boolean isValidID(int id) {
		int sum = 0;
		int multi = 1;
		int length = 0;
		int tempId = id;

		while (tempId > 0) {
			int digit = tempId % 10;
			int multipliedDigit = digit * multi;

			if (multipliedDigit >= 10) {
				multipliedDigit = (multipliedDigit / 10) + (multipliedDigit % 10);
			}
			sum += multipliedDigit;
			multi = (multi == 1) ? 2 : 1;
			tempId /= 10;
			length++;

		}
		if (length != 9) {
			return false;
		}
		return (sum % 10 == 0);

	}

	public static void calculateTrigFunction(double ang) {
		double radius = ((Math.PI * ang) / 180);
		System.out.println("Sin:" + Math.sin(radius));
		System.out.println("Cos:" + Math.cos(radius));
		System.out.println("Tangent:" + Math.tan(radius));
	}

	public static long calculateFactorile(int number) {
		long fact = 0;
		for (int i = 2; i <= number; i++) {
			fact *= i;
		}
		return fact;
	}

	public static String decimalToHex(int number2) {
		if (number2 == 0) {
			return "0";
		}
		String Hex = "";
		char[] Hexchars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (number2 > 0) {
			int remainder = number2 % 16;
			Hex = Hexchars[remainder] + Hex;
			number2 = number2 / 16;
		}
		return Hex;

	}
}
