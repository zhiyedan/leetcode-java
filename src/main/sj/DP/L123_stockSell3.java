package sj.DP;

/**
 * Created by steven on 18-4-3 下午8:25
 * shijia0620@126.com
 * 最多只能买k次
 */
public class L123_stockSell3 {
    public static int solution(int[] prices, int k){
        if(k<=0) return 0;
        int[][] dp = new int[k+1][prices.length+1];
        for(int i=1; i<=k;i++){
            for(int j=1; j<=prices.length; j++){
                int max = dp[i][j-1];
                for(int m=j-1; m>0;m--){
                    max = Math.max(max,prices[j-1]-prices[m-1]+dp[i-1][m]);
                }
                dp[i][j] = max;
            }
        }
        return dp[k][prices.length];
    }

    public static int bestSolution (int[] prices, int k){
        if (k <= 0 || prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        // dp[i][j] 表示 交易i次，到第j天的最大收益
        int[][] dp = new int[k+1][len];

        // 交易次数从1到k开始遍历
        for (int i = 1; i <= k; i++) {
            // 优化点：记录 dp[i-1][m] - prices[m] 最大值，不用每次重复计算，注意初始化
            int maxDiff = -prices[0];
            // 交易第j天遍历，从第1天开始，到len-1天
            for (int j = 1; j < len; j++) {
                // 最大收益为第j天不进行交易，和第j天进行交易，在最大差值买入的收益，两者取最大
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxDiff);
                // 更新maxDiff
                maxDiff = Math.max(maxDiff, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][len-1];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,8,3,7,13},3));
    }
}
