package sj.DP.bag;

public class L377CombinationSum4 {

    // TODO 这个爬楼梯很相似！nums代表一次可以跨越的步数，target为台阶数
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        // TODO 遍历顺序很关键，先背包后物品是排序数，先物品后背包是组合数。
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i-num];
                }
            }
        }

        return dp[target];
    }

}


