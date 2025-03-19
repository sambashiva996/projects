package com.core.java.core_java_programs.practice;

import java.util.ArrayList;

public class PrintDuplicatesOfStringChar {
	
	public static void main(String[] args) {
		
		String s = "abcdefabcder";
		
		ArrayList<Character> list = new ArrayList<Character>();
		
		for(int i = 0; i < s.length(); i++){
			
			char c= s.charAt(i);
			
			if(list.contains(c)) {
				
				continue;
			}else {
				list.add(c);
			}
			
		}
		System.out.println(list);
	}

}
