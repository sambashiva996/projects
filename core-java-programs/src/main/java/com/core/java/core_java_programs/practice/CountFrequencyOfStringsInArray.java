package com.core.java.core_java_programs.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountFrequencyOfStringsInArray {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("samba","samba","shivudu","ambati","ambati");
        Map<String, Integer> map = new HashMap<>();
        for (int i =0; i < list.size(); i++){
            if (map.containsKey(list.get(i))){
                Integer count = map.get(list.get(i));
                map.put(list.get(i), ++count);
            }else {
                map.put(list.get(i),1);
            }
        }
        System.out.println("frequency of strings : "+map);
    }
}
