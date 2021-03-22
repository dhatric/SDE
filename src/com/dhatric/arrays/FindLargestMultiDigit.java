package com.dhatric.arrays;

public class FindLargestMultiDigit {

 	public String largestNumber(int[] nums) {

		if (nums.length == 1) {
			return String.valueOf(nums[0]);
		}
		
		long sum=0;
		for (int index = 0; index < nums.length; index++) {
			sum =  sum+ nums[index];
			if(sum > 0)
				break;
		}
		
		if(sum ==0) {
			return "0";
		}

		for (int index = 0; index < nums.length; index++) {

			for (int subIndex = index + 1; subIndex < nums.length; subIndex++) {

				if (getMergedValue(nums[subIndex], nums[index]) > getMergedValue(nums[index], nums[subIndex])) {
					swap(nums, index, subIndex);
				}
			}

		}
		
		String output= "";
		for (int index = 0; index < nums.length; index++) {
			output = output+ nums[index] ;
		}
		return output;
	}

    
	public long getMergedValue(int value1, int value2) {
        if(value1 == 0) return value2;
		return Long.valueOf(String.valueOf(value1) + String.valueOf(value2));
	}
    
    public void swap(int[] nums, int index1, int index2){
        int value1= nums[index1];
        nums[index1] =  nums[index2];
        nums[index2] = value1;
    }
    

	public static void main(String[] args) {
		FindLargestMultiDigit f = new FindLargestMultiDigit();
		int[] nums = {0,0,0};
		System.out.println(f.largestNumber(nums));

	}

}
