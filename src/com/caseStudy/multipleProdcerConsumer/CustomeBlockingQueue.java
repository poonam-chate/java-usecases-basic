package com.caseStudy.multipleProdcerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class CustomeBlockingQueue<E> {
    private Queue<E> queue;
    int limit;

    public CustomeBlockingQueue(int limit){
        this.limit = limit;
        this.queue = new LinkedList<>();
    }
    public synchronized void enQueue(E e) throws InterruptedException {
        while(queue.size() == limit){
            System.out.println("Queue is full."+ Thread.currentThread().getName()+" is waiting....");
            wait();
        }
        queue.add(e);
        System.out.println("Thread "+Thread.currentThread().getName()+" added element to queue");
        notifyAll();
    }
    public synchronized E deQueue()throws InterruptedException{
        while(queue.size() == 0){
            System.out.println("Queue is empty. "+Thread.currentThread().getName()+ " is waiting....");
            wait();
        }
        E e = queue.remove();
        System.out.println("Thread "+ Thread.currentThread().getName()+" has consumed from queue.");
        notifyAll();
        return e;
    }
}
