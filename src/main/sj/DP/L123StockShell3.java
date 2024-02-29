package sj.DP;

/**
 * 最多买卖两次
 * dp[i][0] 不操作
 * dp[i][1] 第一次持有（不一定第i天进行买入，也有可能是延续之前的第一次买入状态）
 * dp[i][2] 第一次不持有
 * dp[i][3] 第二次持有
 * dp[i][4] 第二次不持有
 */
public class L123StockShell3 {

    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][4];

        // 初始化,可以理解为同一天多次买卖：dp[0][1] = -prices[0]; dp[0][2] = 0; dp[0][3]=-prices[0];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }

        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][3]);

    }

    public int maxProfit2OneArray(int[] prices) {

        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[2] = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            int curPrice = prices[i];
            dp[3] = Math.max(dp[3], dp[2] + curPrice);
            dp[2] = Math.max(dp[2], dp[1] - curPrice);
            dp[1] = Math.max(dp[1], dp[0] + curPrice);
            dp[0] = Math.max(dp[0], -curPrice);

        }

        return Math.max(dp[3], dp[1]);

    }

    public int maxProfitK(int[] prices, int k) {

        int[] dp = new int[2 * k + 1];

        // 初始化dp
        for (int i = 0; i < k; i++) {
            // 奇数为持有股票，偶数为不持有股票状态
            dp[2 * i + 1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 2 * k; j > 0; j--) {
                // 不持有
                if (j % 2 == 0) {
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                } else { // 持有
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                }
            }
        }

        return dp[2 * k];

    }

}
