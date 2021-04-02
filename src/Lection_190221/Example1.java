package Lection_190221;

import java.util.*;

public class Example1 {
    public static void main(String[] args) {
        List list=new Vector<>();
        list.add(1);
        list.add("qwqwqw");
        list.add(23.4);

        System.out.println(list.get(0));
        for(Object temp:list){
            System.out.println(temp.getClass().getName());
        }
        Iterator it1=list.iterator();
        Iterator it2=list.iterator();
//while (it1.hasNext()){
//    list.add(23);
//    System.out.println(it1.next());
//
//   // it1.remove();
//    it2.next();
//}
        List<String> vector=new Vector<>(10000);
        ListIterator<String> listIt=vector.listIterator();
        
        System.out.println(vector.size());
        Byte byt=34;
        Short sh=34;
        Integer in=34;//int
        Long lo=34L;
        Double d=34.0;
        Float fl=34.2f;
        Boolean bol=false;
        Character char1='q';//char

    }
}
