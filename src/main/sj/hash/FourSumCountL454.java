package sj.hash;

import java.util.*;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class FourSumCountL454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int curSum = num1 + num2;
                map.put(curSum, map.getOrDefault(curSum, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int curSum = num3 + num4;
                if (map.containsKey(-curSum)) {
                    result += map.get(-curSum);
                }
            }
        }

        return result;
    }
}
