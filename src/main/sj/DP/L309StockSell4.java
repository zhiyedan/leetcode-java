package sj.DP;

public class L309StockSell4 {
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][3];

        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }

        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);

    }

    public int maxProfitOneArray(int[] prices) {

        int buy = -prices[0];
        int sell = 0;
        int cold = 0;

        for (int i = 1; i < prices.length; i++) {
            int newCold = Math.max(cold, sell);
            int newSell = Math.max(sell, buy + prices[i]);
            int newBuy = Math.max(buy, cold - prices[i]);
            buy = newBuy;
            sell = newShell;
            cold = newCold;
        }

        return Math.max(sell, buy);

    }
}
