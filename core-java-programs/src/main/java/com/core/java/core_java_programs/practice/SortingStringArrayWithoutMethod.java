package com.core.java.core_java_programs.practice;

public class SortingStringArrayWithoutMethod {
    public static void main(String[] args) {
        String[] str = {"samba", "shivudu", "ambati"};

        for (int i = 0; i < str.length; i++){
            for (int j = i+1; j < str.length; j++){

                if (str[i].compareTo(str[j]) > 0){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
            System.out.println("Sorted String array : "+str[i]);
        }
    }
}
