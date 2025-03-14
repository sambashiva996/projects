package com.service.registry;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        //"apple","",null,"Grapes"

        List<String> list = Arrays.asList("apple", "", null ,"Grapes");

        List<String> list1 = list.stream().filter(f -> f !=null && f !="").collect(Collectors.toList());

//        System.out.println(list1);

        //1,2,3,4,6,7

        List<Integer> list2 = Arrays.asList(1,2,3,4,6,7);

                int[] numbers = {1, 2, 3, 4, 6, 7}; // Given sequence
                int start = 1, end = 7;

                Set<Integer> numSet = new HashSet<>();
                for (int num : numbers) numSet.add(num);

                List<Integer> missingNumbers = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    if (!numSet.contains(i)) missingNumbers.add(i);
                }

                System.out.println("Missing numbers: " + missingNumbers);
            }
}
