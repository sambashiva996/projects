package com.core.java.programs.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		/*Java 8*/
		/**/
		String s = "This is my sample string".toLowerCase(); 
		
		char[] c =  s.toCharArray();
		
		List<Character> list = new ArrayList<>();
		
		for(char cc : c) {
			list.add(cc);
		}
		
      Map<Character, Long>	map = 	list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
//      System.out.println(map);
      
        Set<Character> set = new HashSet<>();
        
        Map<Character, Integer> map2 = new LinkedHashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
        	char c1 = s.charAt(i);
        	if (map2.containsKey(c1)) {
        		
        		int num = map2.get(c1);
        		map2.put(c1, ++num);
			}else {
				map2.put(c1, 1);
			}
        }
        
		List<Character> list2 = new ArrayList<>();
        
        for(Map.Entry<Character, Integer> entry : map2.entrySet()) {
        	
        	if (entry.getValue() == 1) {
				list2.add(entry.getKey());
        		break;
			}
        } 
        
        
//        System.out.println(map2 + " and " + list2);
        
		List<Integer> list3 = new ArrayList<>();
		List<Integer> list4 = new ArrayList<>();

        
        for(int i = 1; i < 19; i++) {
        	list3.add(i);
        } 
        
        //start index = 4 and last index = 10
        //out put : 4 to 10 ///////
        
        for(int j = 4 ; j <= 10; j++) {
        	
        	list4.add(list3.get(j));
        
        }
        
        System.out.print(list4);
      
	}

}
