package com.core.java.programs.practice;

import com.core.java.programs.model.CreditCard;
import com.core.java.programs.model.Student;

import java.util.*;


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



    }
}
