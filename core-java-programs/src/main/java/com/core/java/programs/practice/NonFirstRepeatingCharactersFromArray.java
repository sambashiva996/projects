package com.core.java.programs.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NonFirstRepeatingCharactersFromArray {
    public static void main(String[] args) {
        nonRepeatingCharactersFromArray();
    }
    private static void nonRepeatingCharactersFromArray() {
        //        Write a program to find first non-repeating character from a input string
//        Ex:
//        Input : { ""array"", ""apple"", ""rat""}
//        Output: y,a,r"
        String[] arr = new String[]{"array", "apple", "rat"};
        String empty = "";
        for (int i = 0; i < arr.length; i++) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            String str = arr[i];
            for (int j = 0; j < str.length(); j++) {
                char charAt = str.charAt(j);
                if (map.containsKey(charAt)) {
                    int count = map.get(charAt);
                    map.put(charAt, ++count);
                } else {
                    map.put(charAt, 1);
                }
            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entries){
                if (entry.getValue() == 1){
                    empty = empty+""+entry.getKey();
                }
                break;
            }
            if (!empty.isEmpty() && !empty.isBlank()){
                break;
            }
        }
        System.out.println(empty);
    }
}
