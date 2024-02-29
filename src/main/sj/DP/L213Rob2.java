package sj.DP;

import java.util.Arrays;

public class L213Rob2 {

    public static int rob(int[] nums) {

        if (nums.length == 1) return nums[0];

        int a = robBase(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int b = robBase(Arrays.copyOfRange(nums, 0, nums.length - 1));

        return Math.max(a,b);
    }

    public static int robBase(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(robBase(Arrays.copyOfRange(nums, 0, nums.length - 1)));
        System.out.println(robBase(Arrays.copyOfRange(nums, 1, nums.length)));
    }

}
