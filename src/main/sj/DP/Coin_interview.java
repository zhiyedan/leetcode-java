package main.sj.DP;

/**
 * Created by steven on 18-4-22 下午7:49
 * shijia0620@126.com
 */
public class Coin_interview {
    //求有多少种兑换方式,完全背包问题
    public static int coinCounnt(int[] coins, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i= coin; i<=target; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(coinCounnt(new int[]{1,2,5},6));
    }
}
