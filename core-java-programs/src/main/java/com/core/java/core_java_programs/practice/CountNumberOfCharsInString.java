package com.core.java.core_java_programs.practice;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfCharsInString {

	public static void main(String[] args) {
		
		String str = "aabc123defghi345abc123defghi345";
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(map.containsKey(ch)) {
				Integer n = map.get(ch);
				map.put(ch, ++n);
			}
			else {
				map.put(ch, 1);
			}
		}
		
		System.out.print(map);
	}
}
