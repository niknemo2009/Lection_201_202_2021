package Lection300421.SafeClass;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Example2_1 {
    public static void main(String[] args) throws InterruptedException {

        Editor variant1= new Editor() {
            @Override
            int read() {
             return 0;
            }

            @Override
            void write(int value) {

            }
        };
        Editor variant2= new Editor() {
            @Override
            int read() {

               // return this.varSafe.get();
                return this.number;
            }

             @Override
              void write(int value) {

                this.number++;
               // this.varSafe.incrementAndGet();
            }
        };
        Potok potok1=new Potok(variant2,"Potok one",1000);
        Potok potok2=new Potok(variant2,"Potok two",1000);
        Potok potok3=new Potok(variant2,"Potok 3",1000);

        potok1.start();;
        potok2.start();
        potok3.start();
long start=System.currentTimeMillis();
        potok1.join();
        potok2.join();
        potok3.join();

        System.out.println(variant1.number);
        System.out.println(variant2.number);
       // System.out.println(variant1.varSafe.get()+" atomic 1");
        //System.out.println(variant2.varSafe.get()+" atomic 2");

        System.out.println(" Action time= "+(System.currentTimeMillis()-start));
        System.out.println("main terminated +++++++++++++++");
    }
}

class Potok extends Thread{
    Editor editor;
    int counter;

    public Potok(Editor element,String name,int counter)
    {
        this.setName(name);
        this.editor = element;
        this.counter=counter;
    }
    @Override
    public void run() {
        for(int i=0;i<counter;i++){
editor.localLock.lock();
    editor.read();
            editor.localLock.unlock();
    try {
        System.out.println(this.getName() + " read " + i);
        TimeUnit.MICROSECONDS.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
        editor.localLock.lock();
    editor.write(i);
        editor.localLock.unlock();
    }
            System.out.println(this.getName()+" write "+i);


        }
    }
}
