package com.example.demo.multithreading;

public class DemonThreadExample {

    public class TD implements Runnable{

        @Override
        public void run() {
          for(int i=0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
          }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TD t1 = new DemonThreadExample().new TD();
        TD t2 = new DemonThreadExample().new TD();

        Thread td = new Thread(t1);
        Thread tu = new Thread(t2);
        td.setName("Ram");
        tu.setName("Pranav");
        //td.setDaemon(true); //Dukanam Bandh

        
        tu.start();
        tu.join();
        td.start();
    }

}
