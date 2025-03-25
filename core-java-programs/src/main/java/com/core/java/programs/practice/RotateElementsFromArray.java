package com.core.java.programs.practice;

import java.util.Arrays;

public class RotateElementsFromArray {

    public static void main(String[] args) {
        /*Without following time complexity*/
        int[] arr = {1,2,3,4,5,6};
        int rotateNum = 2;
        int length = arr.length;
        int rotateSize = length-rotateNum;
        int[] newArr = new int[length];

        String temp = "";
        for (int i = rotateSize; i < length; i++){
            temp = temp+arr[i];
        }

        int count = rotateNum;
        for (int j = 0; j < rotateSize; j++){
            newArr[count]=arr[j];
            count++;
        }
         count = 0;
        for (String s : temp.split("")){
            newArr[count]=Integer.parseInt(s);
            count++;
        }

        System.out.println(Arrays.toString(newArr));

    }

}
