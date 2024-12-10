
//Sliding Window

package com.example.demo.leet;

import java.util.*;

public class Solution219 {
    public static void main(String[] args) {
    
        int[] nums = {1,2,3,1,2,3};
        int k =2;

// Suggested code may be subject to a license. Learn more: ~LicenseLog:3223203759.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {


                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    System.out.println("Found answer");
                    return;
                }
            }
            map.put(nums[i], i);
        }
        //System.out.println(map)



        String s = "abcA";

        for(char c:s.toCharArray()){
            if(Character.isLowerCase(c)){                
                char c1 = (char)('A'+ (c-'a'));

            }
        }

       /* 
        int left = 0;
        int right =1;
        
        while(left < nums.length && right < nums.length){
            if(nums[left] == nums[right] && Math.abs(left-right) <= k){
                System.out.println("Found answer");
            }
            else{
                right++;
            }
            if(right -left == k){
                left++;
                right = left+1;
            }      
            // If no answer is found
            if (right >= nums.length) {
                System.out.println("No answer found");
            }      
        }
        */
        /*
        boolean letsBreak = false;
        for(int i=0; i < nums.length; i++){
            boolean letsBreak = false;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                   if(Math.abs(i-j) <= k){
                        System.out.println("Hurray");
                        //return true;
                        letsBreak = true;
                        break;
                   }
                }
                if (letsBreak) {
                    break;
                }
            }
        }
         */
    
    
    }
}
