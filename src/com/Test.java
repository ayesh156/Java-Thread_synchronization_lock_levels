package com;

class A{
    public void m(){
        System.out.println(Thread.currentThread().getName()+": Start");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
        
        System.out.println(Thread.currentThread().getName()+": Waiting...");
        
        Object obj = new Object();
        
        synchronized (Object.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" OUT : "+i); 
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
        
        System.out.println(Thread.currentThread().getName()+": End");
    }
}

class MyThread extends Thread{
    A a;
    public MyThread(A a){
        this.a = a;
    }

    @Override
    public void run() {
        a.m();
    }
        
}

public class Test {
    public static void main(String[] args){
        
        A a = new A();
        
        MyThread t1 = new MyThread(a);
        MyThread t2 = new MyThread(a);
        MyThread t3 = new MyThread(a);
        MyThread t4 = new MyThread(a);
        MyThread t5 = new MyThread(a);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
       
    }
}
