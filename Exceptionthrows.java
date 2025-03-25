import java.util.*;
public class Exceptionthrows {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try{
            int a = sc.nextInt();
            int b = 10/a;
            System.out.println("Result is "+b);
            try{
                int [] arr = {0};
                int c = arr[5];
                System.out.println("Result is "+c);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("ArrayIndexOutOfBoundsException");
            }
        }
        catch(ArithmeticException E){
            System.out.println("ArithmeticException");
        }
    }
}
