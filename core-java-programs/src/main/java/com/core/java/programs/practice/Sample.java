package com.core.java.programs.practice;

import com.core.java.programs.model.CreditCard;
import com.core.java.programs.model.Laptop;
import com.core.java.programs.model.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6};
        int rotate = 3;

        rotateArray(arr, rotate);


        List<List<CreditCard>> objectList = new ArrayList<>();
        List<CreditCard> creditCardList = CreditCard.getCreditCard();
        objectList.add(creditCardList);

        List<Student> studentList = Student.getStudentList();

        String s = "sambashivuduambati";

		List<Character> characterList = Arrays.asList('a', 'e', 'i', 'o', 'u');
		Map<Character, Long> collect1 = s.chars()
                .boxed()
                .map(c -> (char) (int) c)
                .filter(characterList::contains)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //OR
        List<String> collect3 = Arrays.stream(s.split("")).filter(characterList::contains).collect(Collectors.toList());
//		System.out.println(collect);

        List<String> list = Arrays.asList("good", "morning");

        List<Character> collect = list.stream().flatMapToInt(String::chars).mapToObj(c -> (char) c).collect(Collectors.toList());
//        System.out.println(collect);

        List<CreditCard> collect2 = objectList.stream().flatMap(List::stream).collect(Collectors.toList());
//        System.out.println(collect1);

    }

    private static void rotateArray(int[] arr, int rotate) {

        //612345
        //561234
        //456123

    }


}
