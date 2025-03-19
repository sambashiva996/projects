package com.core.java.core_java_programs.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfNumbersSumTwoAddUptoTarget {

    public static void main(String[] args) {
 //4 years experience question
/**
 *Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.	 
  You can return the answer in any order
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?*/
    	
//    	Example 1: 
//    		int[] nums = {[2,7,11,15}; int target = 9
//    		Output: [0,1]
//    		Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    		 
//    		Example 2:
//    		Input: nums = [3,2,4], target = 6
//    		Output: [1,2]
//    		int n = nums[0];
    	int[] nums = {11,7,15,2};
    	int target = 9;
    	
    	Map<Integer, Integer> map = new HashMap<>();
        int[] re = null;
    	for(int i = 0; i < nums.length; i++) {
    		int t = target - nums[i];
    		if (map.containsKey(t)) {
				re = new int[] {map.get(t), i};
			}else {
				map.put(nums[i], i);
			}
    	}
    	Arrays.stream(re).forEach(System.out::print);
		}
}
