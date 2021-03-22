package com.dhatric.arrays;

import java.util.Arrays;

public class FindLargestMultiDigitOptimal {
	  public String largestNumber(int[] nums) {
          int n = nums.length;
          Integer[] integers = new Integer[nums.length];
          for (int i = 0; i < n; i++) {
              integers[i] = nums[i];
          }

          Arrays.sort(integers, (o1, o2) -> concate(o1, o2) > concate(o2, o1) ? -1 : 1);
          if (integers[0] == 0) {
              return "0";
          }
          StringBuilder sb = new StringBuilder();
          for (int i : integers) {
              sb.append(i);
          }
          return sb.toString();
      }

      private long concate(long a, long b) {
          long tmp = b;
          do {
              a *= 10;
              tmp /= 10;
          } while (tmp > 0);
          return a + b;
      }
}
