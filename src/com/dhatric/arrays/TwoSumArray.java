package com.dhatric.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class TwoSumArray {

	public static int[] twoSum(int[] nums, int target) {

		int start = 0;
		int end = nums.length-1;

		while (start < end) {
			int sum = nums[start] + nums[end];
			if (sum > target) {
				end = end - 1;
			} else if (sum < target) {
				start = start + 1;
			} else {
				int[] result = { nums[start], nums[end] };
				return result;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int nums[] = {3,2,4};
		System.out.println(twoSum(nums, 6)[0]+ " "+ twoSum(nums, 6)[1]);

	}

}
