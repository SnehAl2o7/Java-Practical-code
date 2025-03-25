import java.util.*;
public class Exceptionusingthrows {
    
    public static int onlypositive(int a, int b)  throws Negative{
        if(a<0 || b<0){
            throw new Negative("no less than zero");
        }

        return a+b;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        try{
            System.out.println(onlypositive(a, b));    
        }catch(Negative n){
            System.out.println("the error is as follows: "+n);
        }
        finally{
            System.out.println("this is finally block");
        }

        sc.close();
    }
}

class Negative extends Exception{
    
    public Negative(String message){
        super(message);    
    }
}