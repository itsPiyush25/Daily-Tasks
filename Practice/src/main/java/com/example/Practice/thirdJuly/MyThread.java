package com.example.Practice.thirdJuly;

public class MyThread extends Thread{
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
                }
    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName() + " is running with the state " + Thread.currentThread().getState());
        }
    }
}


