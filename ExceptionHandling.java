public class ExceptionHandling {
    public static void main(String[] args) {
        // try-catch block
        // try block is used to enclose the code that might throw an exception
        // catch block is used to handle the exception
        // finally is used to execute the code 
        // finally always works if exception get caught or not
        
        try{
            int a = 10;
            int b = 0;
            int c = a/b;
            System.out.println("Result: "+c);
        }
        catch(Exception E){
            System.out.println("Exception Occured: "+E.getMessage());
        }
        finally{
            System.out.println("The program is for dividing a number by zero");
        }
    }
}
