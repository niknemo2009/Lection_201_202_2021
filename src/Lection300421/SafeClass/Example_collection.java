package Lection300421.SafeClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example_collection {

    public static void main(String[] args) {
      List<Integer> list=new ArrayList<>();
        for (int i = 0; i <50 ; i++) {
            list.add(i);
        }
        Iterator<Integer> iter1=list.iterator();
        Iterator<Integer> iter2=list.iterator();
        int k=0;
        // TODO: 4/30/2021 thread list.toString

        while(k<30){
            System.out.println(k+" +++++++++++");
            iter1.next();
            iter1.remove();
           // iter2.next();
            k++;
        }
    }
}
