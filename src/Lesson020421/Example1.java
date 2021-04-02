package Lesson020421;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class Example1 {

    public static void main(String[] args) {
        One one1=new RealisationOne();
        One one2=new One() {
            @Override
            public String one(int par) {
                return null;
            }
        };
       final  int[] par={89};
       Example1 ex1=new Example1();
        One one3= w-> {
            System.out.println("asasasasasa");
            par[0]++;
           // par=new int[3];
            return w+par[0]+"lambda";
        };
        System.out.println(one3.one(3));
        //Two two=(o, r)->Example1::metod1();
        Comparator<String> comp1=(w,r)->w.length()-r.length();
        String[] arr={"qwe","assdsd","q"};
        Arrays.sort(arr,comp1);
        System.out.println(Arrays.toString(arr));
        Consumer<Integer> consum=(q)->{
            System.out.println("sccdcdc");
        };
    }

   static String metod1(){
        return "metod1";

    }

}
@FunctionalInterface
interface  One{
    String one(int par);

}
@FunctionalInterface
interface  Two{
    String two(int par,String par2);

}

class RealisationOne implements One{

    @Override
    public String one(int par) {
        return null;
    }
}