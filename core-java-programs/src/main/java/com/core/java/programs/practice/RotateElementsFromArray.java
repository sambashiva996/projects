package com.core.java.programs.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RotateElementsFromArray {

    public static void main(String[] args) {
//        rotateArrayWithoutTimeComplexity();

        rotateArrayWithTimeComplexity();

    }

    private static void rotateArrayWithTimeComplexity() {
        int[] arr = {1,2,3,4,5,6};
        int rotate = 2;

        //Using streams
        List<Integer> collect = IntStream.range(0, arr.length)
                .mapToObj(m -> arr[(m - rotate + arr.length) % arr.length]) // Circular shift
                .collect(Collectors.toList());
//        System.out.println(collect);
         //OR

        rotateRight(arr, rotate);
        System.out.println(Arrays.toString(arr));
    }
    // Rotate right by k positions using reverse method
    private static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k > n
        reverse(arr, 0, n - 1);      // Reverse the whole array
        reverse(arr, 0, k - 1);      // Reverse first k elements
        reverse(arr, k, n - 1);      // Reverse remaining elements
    }

    // Helper function to reverse array from index 'start' to 'end'
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void rotateArrayWithoutTimeComplexity() {
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
