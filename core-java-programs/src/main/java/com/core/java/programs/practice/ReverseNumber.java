package com.core.java.programs.practice;

public class ReverseNumber {

	public static void main(String[] args) {
		
		int number =123;
		int reverse = 0,reminder = 0;
		
		while(number > 0) {
			reminder = number%10;
			number = number/10;
			reverse = reverse*10+reminder;
		}
		System.out.println("Reverse Number : "+reverse);
	}
}
