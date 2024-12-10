package com.rk.practice;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {

    public static void main(String[] args) {
       Queue<Integer> queue = new LinkedList<>();
        queue.offer(9);
        queue.offer(12);
        queue.offer(23);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

}
