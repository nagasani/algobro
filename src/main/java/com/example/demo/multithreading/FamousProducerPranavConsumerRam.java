package com.example.demo.multithreading;

import java.util.LinkedList;
import java.util.Random;

public class FamousProducerPranavConsumerRam {

    public class Producer implements Runnable{

        LinkedList<Integer> list = new LinkedList<>();
        public Producer(LinkedList<Integer> list){
            this.list = list;
        }

        @Override
        public void run() {
            while(true){
                synchronized(list){
                    if(list.isEmpty()){
                        int i = new Random().nextInt();
                        list.add(i);    
                        System.out.println("Added " + i + " to list");                 
                        list.notifyAll();
                    }
                    else{
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Producer");
                        }
                    }                    
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Consumer implements Runnable{

        LinkedList<Integer> list = new LinkedList<>();
        public Consumer(LinkedList<Integer> list){
            this.list = list;
        }

        @Override
        public void run() {              
            while(true){ 
                synchronized(list){ 
                    if(!list.isEmpty()) {
                        try{                 
                            System.out.println("Removed " + list.remove() + " from list");
                        }
                        catch(Exception ex){
                            System.out.println("Bummmm");
                        } 
                        list.notifyAll();
                    }                  
                    else{
                        try {
                            list.wait();
                        } catch (InterruptedException e) {                           
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();     
        FamousProducerPranavConsumerRam f = new FamousProducerPranavConsumerRam();
        Thread t1 = new Thread(f.new Producer(list));
        Thread t2 = new Thread(f.new Consumer(list));        
        t1.start();
        t2.start();
    }


}
