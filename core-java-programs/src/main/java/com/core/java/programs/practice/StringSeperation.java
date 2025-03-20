package com.core.java.programs.practice;

import java.util.ArrayList;

public class StringSeperation {

	public static void main(String[] args) {
		// Seperate alphabets and integer from given string ?
		ArrayList<Character> cList = new ArrayList<>();
		ArrayList<Character> cList1 = new ArrayList<>();
		String s = "abc123abc123";
		
		System.out.println("Hiiii  :"+s.substring(1,3));
		//method 01
		String s1 = s.replaceAll("[a-z,A-Z]", " ");
		System.out.println("integers :"+s1);
		String s2 = s.replaceAll("[0-9]", " ");
        System.out.println("Aphabets :"+s2);
        //Method 02
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
             int asciValue = (int)c;  //converting into asciValue default start a = 65	
             if(asciValue >= 65) {
            	 char actualChar = (char)asciValue;
            	 cList.add(actualChar);
             }else {
            	 cList1.add(c);
             }
        }
        System.out.println(cList+" and "+ cList1);
	}

}
