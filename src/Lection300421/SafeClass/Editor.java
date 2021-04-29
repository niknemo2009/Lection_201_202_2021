package Lection300421.SafeClass;

import java.util.concurrent.atomic.AtomicInteger;

public abstract  class Editor {
int number=0;
AtomicInteger varSafe=new AtomicInteger(0);
    abstract   int read();
    abstract  void write(int value);
}
