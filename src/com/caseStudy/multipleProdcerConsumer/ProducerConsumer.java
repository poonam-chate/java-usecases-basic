package com.caseStudy.multipleProdcerConsumer;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

    private static Logger  logger = Logger.getLogger("ProducerConsumerLogger");

    public static void main(String args[]) throws InterruptedException {

        final PC pc = new PC();

        for(int i=1;i<=10;i++){
            /*Thread producer =*/ new Thread(()->{
                try{
                    pc.producer(Thread.currentThread().getName());
                }catch (InterruptedException e){
                    logger.log(Level.INFO,"Interrupted exception in producer.");
                }
            }).start();
            /*Thread consumer = */new Thread(()->{
                try{
                    pc.consumer(Thread.currentThread().getName());
                }catch (InterruptedException e){
                    logger.log(Level.INFO,"Interrupted exception in consumer.");
                }
            }).start();
            //  producer.start();
        }

        /*producer.join();
        consumer.join();*/
    }

    public static class PC{
        private LinkedList<Integer> queue = new LinkedList<>();
        int value = 0;
        int capacity = 10;
        public void producer(String threadName) throws InterruptedException{
            while(true){
                synchronized (this){
                    if(queue.size() == capacity){
                        wait();
                    }
                    queue.add(value++);
                    System.out.println("Produced: "+ value + " by Thread:"+ threadName);
                    notifyAll();

                    Thread.sleep(1000);
                }
            }

        }

        public void consumer(String threadName) throws InterruptedException{
            while(true){
                synchronized (this){
                    if(queue.size() == 0){
                        wait();
                    }
                    int consumed = queue.removeFirst();
                    System.out.println("Consumed: "+consumed + " by Thread:"+ threadName);
                    notifyAll();
                    Thread.sleep(1000);
                }
            }
        }
    }
}
