package sj.DP;

/**
 * Created by steven on 18-4-3 下午7:47
 * shijia0620@126.com
 * 股票问题，最多交易一次
 */
public class L121StockSell {

    //TODO dp方法，二维数组，0-存储持有成本，1-存储最大利润。
    public static int maxProfit22(int[] prices) {

        int[][] dp = new int[prices.length + 1][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // TODO 只能买一次，所以是 -prices[i];
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];

    }

    // TODO dp方法，一维数组
    public static int maxProfitArray(int[] prices) {
        int cost = -prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, cost + prices[i]);
            cost = Math.max(cost, -prices[i]);
        }
        return profit;
    }


    // TODO 贪心，核心思路是找到左边的最低值和右边的最高值。
    public static int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }


}
