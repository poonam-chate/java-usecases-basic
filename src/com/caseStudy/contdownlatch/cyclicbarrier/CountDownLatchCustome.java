package com.caseStudy.contdownlatch.cyclicbarrier;

public class CountDownLatchCustome {

    int count;

    public CountDownLatchCustome(int count){
        this.count = count;
    }

    public synchronized void await() throws InterruptedException{
        if(count > 0){
            this.wait();
        }
    }

    public synchronized void countDown(){
        count--;

        if(count == 0){
            this.notifyAll();
        }
    }
}
