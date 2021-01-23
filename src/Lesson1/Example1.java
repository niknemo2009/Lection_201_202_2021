package Lesson1;

import java.time.LocalDate;

public class Example1 {
    int a;
    public static void main(String[] args) {
        System.out.println("dsdsd");
        Human hum=new Human("Ivan",20,LocalDate.of(2001,1,1));
        System.out.println(hum.age);
    }
}

class Human{
    String name;
    int age;
    LocalDate birthday;

    public Human(byte qwe) {

    }

    public Human(String name, int age, LocalDate birthday) {
//        this.name = name;
//        this.age = age;
//        this.birthday = birthday;
    }

    int one(){
     if(3>5){
         return 34;
     }else{
         long qwe=73;
         return (int)qwe;
     }

    }
}