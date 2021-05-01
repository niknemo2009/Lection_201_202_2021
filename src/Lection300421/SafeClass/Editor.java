package Lection300421.SafeClass;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public abstract  class Editor {
volatile int number=0;
ReentrantLock localLock=new ReentrantLock();
AtomicInteger varSafe=new AtomicInteger(0);
    abstract   int read();
    abstract  void write(int value);
}
