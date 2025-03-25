import java.util.Scanner;

public class AgeCal {

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int daysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29; // February in leap year
        }
        return days[month - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for date of birth
        System.out.print("Enter your birth year (YYYY): ");
        int birthYear = scanner.nextInt();
        System.out.print("Enter your birth month (MM): ");
        int birthMonth = scanner.nextInt();
        System.out.print("Enter your birth day (DD): ");
        int birthDay = scanner.nextInt();

        // Taking user input for current date
        System.out.print("Enter current year (YYYY): ");
        int currentYear = scanner.nextInt();
        System.out.print("Enter current month (MM): ");
        int currentMonth = scanner.nextInt();
        System.out.print("Enter current day (DD): ");
        int currentDay = scanner.nextInt();

        // Age calculation
        int ageYear = currentYear - birthYear;
        int ageMonth = currentMonth - birthMonth;
        int ageDay = currentDay - birthDay;

        // Adjust days if current day is before birth day
        if (ageDay < 0) {
            ageMonth--;
            ageDay += daysInMonth((currentMonth == 1) ? 12 : currentMonth - 1, currentYear);
        }

        // Adjust months if current month is before birth month
        if (ageMonth < 0) {
            ageYear--;
            ageMonth += 12;
        }

        // Display result
        System.out.println("Your age is " + ageYear + " years, " + ageMonth + " months, and " + ageDay + " days.");

        scanner.close();
    }
}
