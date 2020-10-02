package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread{
    private Semaphore semaphore;
    private CountDownLatch xdl;
    private int speedDownload = 100;
    private CountDownLatch cdl;

    public Downloaders(String name,Semaphore semaphore,
                       CountDownLatch countDownLatch,
                       CountDownLatch countDownLatch1) {
        super(name);
        this.cdl=countDownLatch;
        this.semaphore = semaphore;
        this.xdl= countDownLatch1;
        start();
    }

    @Override
    public void run() {
        try {
            cdl.await();
            semaphore.acquire();
            System.out.println(getName() + "Скачивает из сервер файла ");
            sleep(500/speedDownload*1000);

            System.out.println(getName() + "успешно скачал файл из сервера");
            xdl.countDown();
            semaphore.release();
        }catch (InterruptedException ignored){}

    }
}
