package com.core.java.core_java_programs.practice;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		/*
		 * Write a function to find the longest common prefix string amongst an array of
		 * strings.
		 */
		String[] strs = { "flower", "flow", "flight" };

		String ss = longestCommonPrefix(strs);

		System.out.print(ss);
	}
	
	public static String longestCommonPrefix(String[] strs) {
		String longprefix = "";
		String finalPrefix = "";
		longprefix = strs[0];
		for(int i = 0; i < strs.length; i++) {
			if(!longprefix.equalsIgnoreCase(strs[i])) {
				if(longprefix.contains(strs[i])) {
					finalPrefix = longprefix;
					longprefix= strs[i];
				}
				else {
					if(strs[i].contains(longprefix)) {
						finalPrefix = strs[i];
						//longprefix= strs[i];
					}
				}
			}
		}
		
		return longprefix;
	}
//	public static String longestCommonPrefix(String[] strs) {
//		String s = "";
//		for (int i = 0; i < strs.length; i++) {
//			char[] c = strs[i].toCharArray();
//			for (int j = i + 1; j < strs.length; j++) {
//				char[] c1 = strs[j].toCharArray();
//				if (c[i] == c1[i]) {
//				s = s + c[i];
//				} else {
//					return "empty";
//				}
//			}
//		}
//		return s;
//	}
}
