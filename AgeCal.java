import java.util.Scanner;

public class AgeCal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter your age:");
        int n = sc.nextInt();
        ageCal(n);
    }

    public static void ageCal(int n) {
        if (n < 0) {
            System.out.println("Invalid Input");
        }
        System.out.println("The person age is " + n + " years," + n * 12 + " months, " + n * 12 * 365 + " days.");
    }
}
