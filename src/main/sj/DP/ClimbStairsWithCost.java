package sj.DP;

/**
 * 使用最小代价爬楼梯
 * 错误点：没搞清楚每个下表代表的含义，列表长度为n，则需走到n+1个台阶
 */
public class ClimbStairsWithCost {
    public static int minCost(int[] costs) {
        int[] dp = new int[costs.length + 1];
        for (int i = 2; i <= costs.length; i++) {
            dp[i] = Math.min(dp[i - 1] + costs[i - 1], dp[i - 2] + costs[i - 2]);
        }
        return dp[costs.length];
    }

    public static void main(String[] args) {
        int[] costs = new int[]{20, 15, 30};
        System.out.println(ClimbStairsWithCost.minCost(costs));
    }
}
