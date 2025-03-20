package com.core.java.programs.practice;

public class SortingCharsWithoutMethod {
    public static void main(String[] args) {
        String str = "samba";

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++){
            for (int j = i+1; j < chars.length; j++){
                char temp = chars[i];
                if (chars[i] > chars[j]){

                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
            System.out.println("Sorted String : "+chars[i]);
        }
    }
}
