package com.rk.practice;

import java.util.Arrays;

public class FindLargestNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{2,8,9,-7,0,4};

        //System.out.println(Arrays.stream(nums).boxed().min((x,y) -> Integer.compare(x, y)));

        int min = Integer.MAX_VALUE;
        for(int i=0; i < nums.length; i++){
           min = Math.min(min, nums[i]);
        }
       System.out.println(min);

    }

}
