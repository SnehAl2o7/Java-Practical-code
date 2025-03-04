import java.util.Scanner;

public class AgeCal {
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    static Scanner scanner = new Scanner(System.in);

    private static int daysInMonth(int month, int year) {

        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && isLeapYear(year)) {
            return 29; // Leap year February
        }
        return days[month - 1];
    }

    public static void main(String[] args) {
        // Taking user input for date of birth
        System.out.print("Enter your birth year (YYYY): ");
        int birthYear = scanner.nextInt();
        System.out.print("Enter your birth month (MM): ");
        int birthMonth = scanner.nextInt();
        System.out.print("Enter your birth day (DD): ");
        int birthDay = scanner.nextInt();

        // Taking user input for current date
        System.out.print("Enter current year (YYYY): ");
        int Year = scanner.nextInt();
        System.out.print("Enter current month (MM): ");
        int Month = scanner.nextInt();
        System.out.print("Enter current day (DD): ");
        int Day = scanner.nextInt();

        int ageYear = Year - birthYear;
        if (Day < 0) {
            Month--;
            Day += daysInMonth(birthMonth, birthYear);
        }
        if (Month < 0) {
            ageYear--;
            Month += 12;
        }
        System.out.println("Your age is " + ageYear + " years, " + Month + " months," + Day +
                " ,days");

    }
}
