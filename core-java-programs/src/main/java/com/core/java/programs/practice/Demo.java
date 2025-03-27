package com.core.java.programs.practice;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {


        List<Integer> l1= Arrays.asList(1,3,5,8,9,4,2,null);
        List<Integer> l2= Arrays.asList(1,4,7,9,23,24);
        List<List<Integer>> flatList = new ArrayList<>();
        flatList.add(l1);
        flatList.add(l2);

        List<Integer> r = l1.stream().filter(f -> l2.contains(f)) .collect(Collectors.toList());
//        System.out.println(r);

        Map<Boolean, List<Integer>> collect = l1.stream().filter(f -> l2.contains(f)).collect(Collectors.partitioningBy(p -> p % 2 == 0));

//        System.out.println("even Number :"+collect.get(true) +" and odd number " + collect.get(false));

        List<Integer> collect1 = flatList.stream().flatMap(List::stream).filter(f -> Objects.nonNull(f)).collect(Collectors.toList());
//        System.out.println(collect1);

//        andAndOperatorUsecases();

//        stringsUseCases();


    }

    private static void stringsUseCases() {
        String s = "samba";
        String s1 = "samba";
        String s2 = new String("samba").intern();

        System.out.println(s==s2);
    }

    private static void andAndOperatorUsecases() {
        int a = 1;
        int b = 1;

        if ((a == 1) & (b++ == 2)) {  // b is incremented regardless
            System.out.println("Using & : Condition met");
        }
        System.out.println("b after & : " + b); // Output: 3

        b = 2; // Reset b

        if ((a == 1) && (b++ == 2)) {  // b is incremented only if first condition is true
            System.out.println("Using && : Condition met");
        }
        System.out.println("b after && : " + b); // Output: 3
    }
}
