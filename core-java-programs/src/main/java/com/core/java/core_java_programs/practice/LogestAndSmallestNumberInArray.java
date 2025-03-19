package com.core.java.core_java_programs.practice;

public class LogestAndSmallestNumberInArray {

	public static void main(String[] args) {

		int[] arr = { 4, 2, 6, 1, 8 };
		int longest = arr[0];
		int smallest = arr[0];

		int secondLongest = 0;
		int secondSmallest = 0;

		// find Longest and Smallest Number ?

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > longest) {
				longest = arr[i];
			}
			if (arr[i] < smallest) {
				smallest = arr[i];
			}
		}
		System.out.println("longest number :" + longest + " ,smallest number :" + smallest);

		// Longest and Second Longest Number ?

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] > longest) {
				secondLongest = longest;
				longest = arr[j];
			} else if (secondLongest < arr[j]) {
				secondLongest = arr[j];
			}
		}

		System.out.print("Longest Number :" + longest + " ,SecondLongest Number :" + secondLongest);

		// Smallest and SecondSmallest Number ?
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] < smallest) {
				secondSmallest = smallest;
				smallest = arr[k];
			} else if (secondSmallest > arr[k]) {
				secondSmallest = arr[k];
			}
		}
		System.out.print("Smallest Number :" + smallest + " ,SecondSmallest Number :" + secondSmallest);
	}
}
