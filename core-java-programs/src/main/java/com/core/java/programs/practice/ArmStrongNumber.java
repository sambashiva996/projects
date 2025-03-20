package com.core.java.programs.practice;

public class ArmStrongNumber {

	public static void main(String[] args) {
		
		int number = 15;
		int temp = number;
		int reminder = 0;
		int armStrongNumber = 0;
		
		while(number > 0) {
			reminder = number%10;
			number = number/10;
			armStrongNumber = armStrongNumber+reminder*reminder*reminder;
		}
		if(armStrongNumber == temp) {
			System.out.println("ArmStrongNumber : "+armStrongNumber);
		}else {
			System.out.println("Not a ArmStrongNumber");
		}
	}
}
