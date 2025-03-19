package com.core.java.core_java_programs.practice;

public class SwapNumbersWithoutThirdVariable {

	public static void main(String[] args) {
		
		int n1=2;
		int n2=4;
		
		System.out.println("Before Swapping :"+n1+" "+n2);
		
		n1 = n1+n2;
		n2 = n1-n2;
		n1 = n1-n2;
		
		System.out.println("After Swapping :"+n1+" "+n2);

	}

}
