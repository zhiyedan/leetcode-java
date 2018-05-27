package sj.DP;

/**
 * Created by steven on 18-4-3 下午8:19
 * shijia0620@126.com
 * 可以买多次
 */
public class L122_stockSell2 {
    public static int maxProfit(int[] prices){
        if(prices.length<1) return 0;
        int profit = 0;
        for (int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
