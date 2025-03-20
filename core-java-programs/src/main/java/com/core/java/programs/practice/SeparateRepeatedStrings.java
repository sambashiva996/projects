package com.core.java.programs.practice;

import java.util.ArrayList;
import java.util.List;

public class SeparateRepeatedStrings {
    public static void main(String[] args) {

        String str = "Abc123abc123";
        char[] chars = str.toCharArray();

        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        for (int i =0 ; i < chars.length; i ++){
            if (chars[i] < 65){
           list1.add(chars[i]);
            }else {
                list2.add(chars[i]);
            }
        }
        System.out.print("separated Strings : "+list1+list2);
    }
}
