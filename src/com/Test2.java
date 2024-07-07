package com;

class B {
    synchronized void m(){
        X x = new X();
        synchronized (x) {
            System.out.println("X");
            Y y = new Y();
            synchronized (y) {
                System.out.println("Y");
            }
        }
    }
}

class X {
    
}

class Y {
    
}

public class Test2 {
    public static void main(String[] args) {
        B b = new B();
        b.m();
    }
    
}
