package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread{
    private CountDownLatch cdl;
    private int fileSize = 500;
    private int scorost = 20;

    public Uploader(CountDownLatch countDownLatch){
        this.cdl = countDownLatch;
        start();
    }

    @Override
    public void run() {
        System.out.println("Началась загруска файла на сервер");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("______*______");
                sleep(fileSize /scorost*100);
            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Загрузка завершена!");
    cdl.countDown();
    }
}
