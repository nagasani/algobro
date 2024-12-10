package com.example.demo.multithreading;

import java.util.HashMap;

public class ThreadExample {

    public static void main(String[] args) {
      
        
        //We recieved Order
        AvailabeDriver ad = new ThreadExample().new AvailabeDriver();
        //ad.run();
        Thread tad = new Thread(ad);
        tad.start();

        Payment p = new ThreadExample().new Payment();
        Thread tpa = new Thread(p);
        tpa.start();
        //p.run();

        Notification n = new ThreadExample().new Notification();
        //n.run();
        Thread tno = new Thread(n);
        tno.start();

        ThreadActual ta = new ThreadActual();

        Thread tta = new Thread(ta);
        tta.start(); 

    }


    public class AvailabeDriver implements Runnable{
        @Override
        public void run() {           
            System.out.println("Available driver");
        }        
    }

    public class Payment implements Runnable{
        @Override
        public void run() {
            System.out.println("Payment");
        }        
    }
    

    public class Notification implements Runnable{
        @Override
        public void run() {
            System.out.println("Notification");
        }        
    }

}
