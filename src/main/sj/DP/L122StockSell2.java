package sj.DP;

/**
 * Created by steven on 18-4-3 下午8:19
 * shijia0620@126.com
 * 可以买多次
 */
public class L122StockSell2 {

    // DP 方法
    public static int maxProfitDp(int[] prices) {

        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            //TODO 可以买多次，所以是dp[i - 1][1] - prices[i]；
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    // 贪心
    public static int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
