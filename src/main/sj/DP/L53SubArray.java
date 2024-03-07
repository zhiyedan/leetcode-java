package sj.DP;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class L53SubArray {

    public int maxSubArray(int[] nums) {

        int result = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    /**
     * 空间优化
     * @param nums
     * @return
     */
    public int maxSubArraySimple(int[] nums) {

        int result = nums[0];
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre+nums[i]);
            result = Math.max(pre, result);
        }

        return result;
    }
}
