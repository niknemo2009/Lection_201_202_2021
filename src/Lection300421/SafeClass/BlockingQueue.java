package Lection300421.SafeClass;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
    private List queue = new LinkedList();
    private int limit = 10;
    public BlockingQueue(int limit) {
        this.limit = limit;
    }
    public synchronized void enqueue(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        System.out.println(item.toString());
        this.queue.add(item);
    }
    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue synCollection=new BlockingQueue(10);
        Thread producer=new Thread(()->{
            for (int i = 0; true ; i++) {
                try {
                    synCollection.enqueue("******* producer"+1+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer=new Thread(()->{
            for (int i = 0; true ; i++) {
                try {
                    synCollection.dequeue();
                    System.out.println("consumer" + 1 + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
