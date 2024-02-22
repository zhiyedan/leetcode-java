package sj.DP.bag;

public class L416CanPartition {
    // TODO 转换为背包问题：能不能把背包装满？
    // 原始背包问题dp[j]表示容量j的最大价值，装满价值最大！
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }

    public static boolean canPartitionOld(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][target] == target;
    }
}
