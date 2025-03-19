package com.core.java.core_java_programs.practice;

import java.util.Scanner;

public class FiboNacciSeries {

	public static void main(String[] args) {
		int n1 = 0, n3 = 0;
		int n2 = 1;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Number : ");
		int fiboNacciNumber = sc.nextInt();
		
		System.out.print(n1+" "+n2);
		
		for(int i = 2; i <= fiboNacciNumber; i++) {
			n3 = n1+n2;
			System.out.print(" "+n3);
			
			n1 = n2;
			n2 = n3;
		}
	}
}
