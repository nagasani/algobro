//back Tracking

package com.example.demo.leet;

import java.util.*;

public class Solution78 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), nums, 0);        
     } 
     
// Suggested code may be subject to a license. Learn more: ~LicenseLog:2865548954.
     private static void backTrack(List<List<Integer>> bigList, List<Integer> smallList, int[] nums, int start) {
       bigList.add(new ArrayList<>(smallList)); //{{},{1}, {1,2}, {1,2,3}, {1,3}, {2}, {2,3}, {3}}
       for(int i=start; i < nums.length; i++ ){

        smallList.add(nums[i]); //smallList{1,2}  1,3
        backTrack(bigList, smallList, nums, i+1);
        smallList.remove(smallList.size()-1);

       }
        
     }

}

//List<List<Integer>>
// {  {1,2},{3,5},{1,2} };
//{ {},{1,2} {1,3}, {2,3}, {} }