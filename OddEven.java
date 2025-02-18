import java.util.*;

public class OddEven {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter length of array: ");
        int n = s.nextInt();
        int[] arr = new int[n];
        int Osum = 0, Esum = 0;
        System.out.println("Enter the elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        for (int i : arr) {
            if (i % 2 == 0)
                Osum += i;
            else
                Esum += i;
        }
        System.out.println("The sum of odd Numbers are : " + Osum);
        System.out.println("The sum of even Numbers are : " + Esum);
    }
}
