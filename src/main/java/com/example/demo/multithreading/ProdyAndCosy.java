package com.example.demo.multithreading;

import java.util.*;

public class ProdyAndCosy {

    public class Prody implements Runnable{
        List<Long> list = new ArrayList<>();

        public Prody(List<Long> list){
            this.list = list;
        }

        @Override
        public void run() {
            while(true){
                synchronized(list){
                    if(list.isEmpty()){
                        list.add(System.currentTimeMillis());
                        System.out.println("Added "+ list.get(0));
                        list.notifyAll();
                    }
                    else{
                        try {
                            list.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        };
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class Cosy implements Runnable{
        List<Long> list = new ArrayList<>();
        
        public Cosy(List<Long> list){
            this.list = list;
        }

        @Override
        public void run() {
            
            while(true){

                synchronized(list){

                    if(!list.isEmpty()){
                        System.out.println("Removing "+ list.remove(0));
                        list.notifyAll();
                    }
                    else{
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // try {
                    //     Thread.sleep(5000);
                    // } catch (InterruptedException e) {
                    //     e.printStackTrace();
                    // }

                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static void main(String[] args) {
        
        List<Long> list = new ArrayList<>();
        Prody p = new ProdyAndCosy().new Prody(list);
        Cosy c = new ProdyAndCosy().new Cosy(list);
        Thread tp = new Thread(p);
        Thread tc = new Thread(c);

        tp.start();
        tc.start();
    }

}
