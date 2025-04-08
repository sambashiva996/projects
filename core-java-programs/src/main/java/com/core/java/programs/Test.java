package com.core.java.programs;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        String s = "java example";


        String s1 = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(f -> f.getValue() > 1).map(m -> m.getKey()).findFirst().get();
        System.out.println(s1);
    }

}
