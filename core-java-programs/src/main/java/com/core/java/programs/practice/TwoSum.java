package com.core.java.programs.practice;

public class TwoSum {

	public static void main(String[] args) {
		/* Given an array of integers nums and 
		an integer target, return indices of the two 
				numbers such that they add up to target.
				
				Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
				*/
		int[] nums = {2,7,11,1};
		int target = 3;
		int[] twoSum = twoSum(nums, target);
		for(int k = 0; k < twoSum.length; k++) {
		System.out.println(twoSum[k]);
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
		   int[] sum = new int[2];
		for(int i = 0; i < nums.length; i++) {
			for(int j = i+1; j < nums.length; j++) {
				
				int t = nums[i]+nums[j];
				if(t == target) {
					sum[0] = i;
					sum[1] = j;
				}
			}
		}
		return sum;
    }

}
