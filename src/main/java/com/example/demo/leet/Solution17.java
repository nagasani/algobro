//Back Tracking

package com.example.demo.leet;

import java.util.*;

public class Solution17 {
    
    public static Map<Integer, List<String>> map = new HashMap<>();
    static {
        map.put(2, Arrays.asList("a","b","c"));
        map.put(3, Arrays.asList("d","e","f"));
        map.put(4, Arrays.asList("g","h","i"));
        map.put(5, Arrays.asList("j","k","l"));
        map.put(6, Arrays.asList("m","n","o"));
        map.put(7, Arrays.asList("p","q","r","s"));
        map.put(8, Arrays.asList("t","u","v"));
        map.put(9, Arrays.asList("w","x","y","z"));
    }

    public static void main(String[] args) {
        
        String digits = "23";

        //if(digits == null || digits.length()==0) return new ArrayList<>();

        //List<String> res = new ArrayList<>();
       

      
        List<List<String>> numbers = new ArrayList<>();
        //numbers.add(firstNum);
        //numbers.add(secondNum);

        // for(int i =0; i < numbers.size(); i++){
        //     for(int j =i+1; j < numbers.size(); j++){
                
                
        //         //System.out.println(firstNum.get(i) + secondNum.get(j));
                 
        //     }
        // }

        List<String> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), digits, 0);
        System.out.println(result);        

    }

   //234
    public static void backTrack(List<String> result, List<String> current, String digits, int index){
        if(current.size() == digits.length()){
            result.add(String.join("",current));
            current = new ArrayList<>();
            return;           
        }
        char digit = digits.charAt(index);
        List<String> letters = map.get(Integer.parseInt(String.valueOf(digit)));
        for(String letter : letters){
            current.add(letter);
            backTrack(result, current, digits, index+1);
            current.remove(current.size()-1);

        }
    }

}
