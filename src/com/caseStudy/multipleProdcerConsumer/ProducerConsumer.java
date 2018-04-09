package com.caseStudy.multipleProdcerConsumer;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

    private static Logger  logger = Logger.getLogger("ProducerConsumerLogger");

    public static void main(String args[]) throws InterruptedException {

        final PC pc = new PC();

        Thread producer = new Thread(()->{
            try{
                pc.producer();
            }catch (InterruptedException e){
                logger.log(Level.INFO,"Interrupted exception in producer.");
            }

        });
        Thread consumer = new Thread(()->{
            try{
                pc.consumer();
            }catch (InterruptedException e){
                logger.log(Level.INFO,"Interrupted exception in consumer.");
            }
        });
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

    public static class PC{
        private LinkedList<Integer> queue = new LinkedList<>();
        int value = 0;
        int capacity = 10;
        public void producer() throws InterruptedException{
            while(true){
                synchronized (this){
                    if(queue.size() == capacity){
                        wait();
                    }
                    queue.add(value++);
                    System.out.println("Produced: "+ value);
                    notifyAll();

                    Thread.sleep(1000);
                }
            }

        }

        public void consumer() throws InterruptedException{
            while(true){
                synchronized (this){
                    if(queue.size() == 0){
                        wait();
                    }
                    int consumed = queue.removeFirst();
                    System.out.println("Consumed: "+consumed);
                    notifyAll();
                    Thread.sleep(1000);
                }
            }
        }
    }
}
