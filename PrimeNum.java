import java.util.Scanner;

class Number {
    int n1, n2;

    Number(int a, int b) {
        this.n1 = a;
        this.n2 = b;
    }

    void printPrime(int a, int b) {
        for (int i = a; i <= b; i++) {
            if (prime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    boolean prime(int a) {
        int check = 0;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                check++;
            }
        }
        if (check == 0)
            return true;
        else
            return false;
    }
}

public class PrimeNum {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a number : ");
        int a = sc.nextInt();
        System.out.println("Enter another number : ");
        int b = sc.nextInt();
        Number num = new Number(a, b);
        num.printPrime(a, b);
    }
}
