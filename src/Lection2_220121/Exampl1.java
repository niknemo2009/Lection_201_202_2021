package Lection2_220121;


import java.util.List;
import java.util.Vector;

public class Exampl1 {
static List wer=new Vector();
//   static {
//        System.out.println("Static Init ");
//    }
//
//    {
//        System.out.println("Init 2");
//    }
    public static void main(String[] args) {
     Exampl1 ex1=new Exampl1();
     Exampl1 ex2=new Exampl1();

    }
//    {
//        System.out.println("Init 1");
//    }
    void two() throws Exception {
        throw  new Exception();
    }

     void one(){
try {


    try {
        int i = 3/0;
        System.out.println("sddsdsds");
        if (i == 3) {
            throw new IllegalStateException();
        }
        System.out.println("qaz");

    } catch (IllegalStateException e) {
        System.out.println("1 catch");
        System.out.println("qaz");
        System.exit(1);
    }//catch (Exception r){
//             System.out.println("2 catch");
//            // System.exit(1);
//         }
    finally {
        System.out.println(" finally ");
    }
} catch(ArithmeticException qwe){
    System.out.println("OUT try");

}
finally {
    System.out.println("OUT finally ");
}

//one();
    }
}

class TestAnalisator{

    public static void main(String[] args) {
       Exampl1 ex1=new Exampl1();
//        Exampl1 ex2=new Exampl1();
      //  System.out.println(Exampl1.wer);
        ex1.one();
      //  ex1.two();
        throw  new MyException();
       // Exampl1.one();


    }
}

class MyException extends  Exception{
    String name;
    public MyException(String message, String nameBadUser) {
        super(message);
    }
}