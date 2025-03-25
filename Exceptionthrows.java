public class Exceptionthrows {
    public static void main(String[] args) {
        try{
            int a = args.length;
            int b = 10/a;
            try{
                int [] arr = {0};
                int c = arr[5];
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
