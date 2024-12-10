package com.example.demo.leet;

import java.util.*;

class Solution3 {

    public static int lengthOfLongestSubstring(String s) {
      int maxLength = 0;
      int left = 0;  
      Set<Character> set = new HashSet<>();
        for(int right=0; right < s.length(); right++){
            Character c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLength = Math.max(maxLength, right-left+1);        
        }
        return maxLength;     
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        String test4 = "";

        System.out.println("Test case 1: " + test1 + " -> " + lengthOfLongestSubstring(test1)); // Expected: 3
        System.out.println("Test case 2: " + test2 + " -> " + lengthOfLongestSubstring(test2)); // Expected: 1
        System.out.println("Test case 3: " + test3 + " -> " + lengthOfLongestSubstring(test3)); // Expected: 3
        System.out.println("Test case 4: " + test4 + " -> " + lengthOfLongestSubstring(test4)); // Expected: 0
    }
}