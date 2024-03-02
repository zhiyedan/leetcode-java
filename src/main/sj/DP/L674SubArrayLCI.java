package sj.DP;

public class L674SubArrayLCI {

    // 贪心
    public int findLengthOfLCIS(int[] nums) {
        int curMax = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curMax++;
                result = Math.max(result, curMax);
            } else {
                curMax = 1;
            }
        }
        return result;
    }

    // dp
    public int findLengthOfLCISdp(int[] nums) {

        int result = 1;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

}
