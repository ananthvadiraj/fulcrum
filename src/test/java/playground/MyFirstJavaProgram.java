package playground;

/**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 30/03/14
 * Time: 10:18
 * To change this template use File | Settings | File Templates.
 */
public class MyFirstJavaProgram {

    public static void main(String args[]) {
        int a=33;

        if(a%5==0 && a%3==0){
            System.out.println("FIZZBUZZ");
        }
        else if(a%5==0){
            System.out.println("FIZZ");
        }
        else if(a%3==0){
            System.out.println("BUZZ");
        }
        else{
            System.out.println("check your input");
        }
    }
}
