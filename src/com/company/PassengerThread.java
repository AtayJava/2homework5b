package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread  extends Thread{
    private Semaphore semaphore;
    private CountDownLatch cdl;

    public PassengerThread(String name, Semaphore semaphore, CountDownLatch cdl) {
        super(name);
        this.semaphore = semaphore;
        this.cdl = cdl;
    }

    public void run() {
        try {
            System.out.println(this.getName() + " подошел на кассу");
            semaphore.acquire();
            sleep(2000);
            System.out.println(this.getName() + " купил билет");
            sleep(1000);
            semaphore.release();
            System.out.println(this.getName() + " сел в автобус");
            cdl.countDown();
            cdl.await();

        } catch (Exception e) {
            System.out.println("Ошибка ");
        }


    }

}
