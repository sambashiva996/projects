package com.core.java.programs.practice;

import com.core.java.programs.model.CreditCard;
import com.core.java.programs.model.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;


public class Sample {
    public static void main(String[] args) {

        List<List<CreditCard>> objectList = new ArrayList<>();
        List<CreditCard> creditCardList = CreditCard.getCreditCard();
        objectList.add(creditCardList);

        List<Student> studentList = Student.getStudentList();

        String s = "sambashivuduambati";

        List<Character> characterList = Arrays.asList('a', 'e', 'i', 'o', 'u');

        List<String> list = Arrays.asList("good", "morning");

        String str = "{[()]}";

        int[] array7 = {1,2,3,4,4,5,5,6,6,6,7,7,7,8,8,8};

        List<Map.Entry<Integer, Long>> collect = Arrays.stream(array7).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).collect(Collectors.toList());

        int[] array8 = {1,2,3,4};


    }
}
