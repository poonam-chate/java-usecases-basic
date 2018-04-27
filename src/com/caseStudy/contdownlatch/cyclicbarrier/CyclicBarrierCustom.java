package com.caseStudy.contdownlatch.cyclicbarrier;

public class CyclicBarrierCustom {

    int initialParties;
    int partiesAwait;
    Runnable barrierPoint;

    public CyclicBarrierCustom(int parties, Runnable barrierPoint){
        this.initialParties = parties;
        this.partiesAwait = parties;
        this.barrierPoint = barrierPoint;
    }

    public synchronized void await() throws InterruptedException{
        partiesAwait--;

        //If the current thread is not the last to arrive, thread will wait.
        if(partiesAwait>0){
            this.wait();
        }
           /*If the current thread is last to arrive, notify all waiting threads, and
            launch event*/
        else{
                  /* All parties have arrive, make partiesAwait equal to initialParties,
                    so that CyclicBarrier could become cyclic. */
            partiesAwait=initialParties;

            notifyAll(); //notify all waiting threads

            barrierPoint.run(); //launch event
        }

    }
}
