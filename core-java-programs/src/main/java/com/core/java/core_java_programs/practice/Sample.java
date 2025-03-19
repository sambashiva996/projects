package com.core.java.core_java_programs.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {

        String s = "sambashivuduambati";

		List<Character> characterList = Arrays.asList('a', 'e', 'i', 'o', 'u');
		Map<Character, Long> collect = s.chars().boxed().map(c -> (char) (int) c).filter(f -> characterList.contains(f)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);

//		int[] nums = {11,7,15,2};
//    	int target = 9;
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] re = null;
//    	for(int i = 0; i < nums.length; i++) {
//    		int t = target - nums[i];
//    		if (map.containsKey(t)) {
//				re = new int[] {map.get(t), i};
//			}else {
//				map.put(nums[i], i);
//			}
//    	}
//    	Arrays.stream(re).forEach(System.out::print);
    }
}
