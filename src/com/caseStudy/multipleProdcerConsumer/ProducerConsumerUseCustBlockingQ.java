package com.caseStudy.multipleProdcerConsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerUseCustBlockingQ {

    private static Logger logger = Logger.getLogger("ProducerConsumerLogger");
    public static void main(String args[]){
        final PC pc = new PC();
        new Thread(()->{
            try{
                pc.producer(Thread.currentThread().getName());
            }catch (InterruptedException e){
                logger.log(Level.INFO,"Interrupted exception in producer.");
            }
        }).start();

        new Thread(()->{
            try{
                pc.consumer(Thread.currentThread().getName());
            }catch (InterruptedException e){
                logger.log(Level.INFO,"Interrupted exception in consumer.");
            }
        }).start();

    }

    public static class PC{

        private CustomeBlockingQueue<Integer> queue = new CustomeBlockingQueue<>(10);
        int value = 0;
        int capacity = 10;

        public void producer(String threadName) throws InterruptedException {
            while(true){
                queue.enQueue(++value);
                Thread.sleep(1000);
            }
        }

        public void consumer(String threadName) throws InterruptedException {
            while (true){
                queue.deQueue();
                Thread.sleep(1000);
            }
        }
    }
}
