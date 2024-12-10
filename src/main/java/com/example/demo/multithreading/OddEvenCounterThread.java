package com.example.demo.multithreading;

public class OddEvenCounterThread {

    // Shared counter object
    private final Object lock = new Object();
    private Integer counter = 1; // Shared state

    public class Odd implements Runnable {
        @Override
        public void run() {
            while (counter <= 100) {
                synchronized (lock) {
                    // Check if the counter is odd
                    if (counter % 2 == 1) {
                        System.out.println("Odd " + counter);
                        counter++;
                        lock.notify(); // Notify the other thread
                    } else {
                        try {
                            lock.wait(); // Wait for the other thread
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Restore the interrupted status
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public class Even implements Runnable {
        @Override
        public void run() {
            while (counter <= 100) {
                synchronized (lock) {
                    // Check if the counter is even
                    if (counter % 2 == 0) {
                        System.out.println("Even " + counter);
                        counter++;
                        lock.notify(); // Notify the other thread
                    } else {
                        try {
                            lock.wait(); // Wait for the other thread
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Restore the interrupted status
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEvenCounterThread threadExample = new OddEvenCounterThread();

        // Create odd and even threads
        Thread oddThread = new Thread(threadExample.new Odd());
        Thread evenThread = new Thread(threadExample.new Even());

        // Start the threads
        oddThread.start();
        //oddThread.
        evenThread.start();
    }
}
