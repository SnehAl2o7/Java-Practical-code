import java.util.*;
public class Exceptionusingthrow {
    public static Scanner sc = new Scanner(System.in);
    // using throw in exception handling
    public static void main(String[] args) {
        try{
            System.out.println("Enter a number :");
            int num = sc.nextInt();
            System.out.println("Enter a number :");
            int num2 = sc.nextInt();
            if(num2 == 0){
                throw new MyException("Error");
            }
            System.out.println("Result : " + (num/num2));
        }
        catch(MyException exe){
            System.out.println(exe.getMessage());
        }
        catch(Exception e){
            System.out.println("Exception caught : " + e.getMessage());
        }
    }
}

class MyException extends Exception{
    MyException(String message){
        super(message);
    }

    public String toString(){
        return "The exception is " + getMessage()+ ".";
    }
}

