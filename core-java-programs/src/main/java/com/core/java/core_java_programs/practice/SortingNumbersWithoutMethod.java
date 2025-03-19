package com.core.java.core_java_programs.practice;

public class SortingNumbersWithoutMethod {

	public static void main(String[] args) {
		int[] arr = {4,2,1,5,8};
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {

				int temp = arr[i];
				if(arr[i] > arr[j]){

					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println("Sorted Numbers : "+ arr[i]);
		}
	}
}
