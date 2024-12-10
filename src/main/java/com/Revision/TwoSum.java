package com.Revision;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,6,8,10,13}; //Sorted
        int target = 13;
        int left =0;
        int right = nums.length-1;

        while(left < right){
            int val = nums[left] + nums[right];
            if(val == target) {
                System.out.println(left+" : "+right);
                break;
            }
            if(val > target) right--;
            if(val < target) left++;
        }

    }
    
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Set<List<Integer>> set = new HashSet<>(); 
        List<List<Integer>> result = new ArrayList<>();

        // Sort the input array in ascending order
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element of the triplet
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = -nums[i];
                Map<Integer, Integer> map = new HashMap<>();

                for (int j = i + 1; j < nums.length; j++) {
                    int complement = target - nums[j];

                    if (map.containsKey(complement)) {
                        result.add(Arrays.asList(nums[i], complement, nums[j]));

                        // Skip duplicates for the second element of the triplet
                        while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                            j++;
                        }
                    }

                    map.put(nums[j], j);
                }
            }
        }

        return result;
    }
}
