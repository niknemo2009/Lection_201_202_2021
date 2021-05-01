package Lection300421.SafeClass;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

//        while(k<30){
//            System.out.println(k+" +++++++++++");
//            iter1.next();
//            iter1.remove();
//            iter2.next();
//            k++;
//        }
        long result=0;
        LocalDate dateNow = LocalDate.now();
        LocalDate birthday = LocalDate.of(1998, 5, 21);
        int monthBD=birthday.getMonthValue();
        int dayBD=birthday.getDayOfMonth();
        System.out.println(monthBD+" "+dayBD);
        LocalDate currentYearBD=LocalDate.of(dateNow.getYear(),monthBD,dayBD);
        if(currentYearBD.isAfter(dateNow)||currentYearBD.equals(dateNow)){
            result = dateNow.until(currentYearBD, ChronoUnit.DAYS);
        }else{
            LocalDate nextYearBD=LocalDate.of(dateNow.getYear()+1,monthBD,dayBD);
            result=dateNow.until(nextYearBD, ChronoUnit.DAYS);
        }
        System.out.println(result);

        long days = birthday.until(dateNow, ChronoUnit.DAYS);
        System.out.println(days);
    }
}
