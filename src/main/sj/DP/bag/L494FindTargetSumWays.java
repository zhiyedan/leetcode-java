package sj.DP.bag;

public class L494FindTargetSumWays {

    // TODO 本题则是装满有几种方法。这就是一个组合问题了。
    public int findTargetSumWaysOld(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // TODO 关键0：不能为负数
        if (sum + target < 0 || (sum + target) % 2 != 0) return 0;

        int groupSum = (sum + target) / 2;

        int[][] dp = new int[nums.length + 1][groupSum + 1];
        // TODO 关键1：
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {

            // TODO 关键2：从0开始而不是1，保证都是0-0=1；
            for (int j = 0; j <= groupSum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][groupSum];
    }

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // TODO 关键0：不能为负数
        if (sum + target < 0 || (sum + target) % 2 != 0) return 0;

        int groupSum = (sum + target) / 2;

        int[] dp = new int[groupSum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = groupSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[groupSum];
    }
}
