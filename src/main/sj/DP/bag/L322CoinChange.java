package sj.DP.bag;

public class L322CoinChange {
    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // TODO 这一步很关键，除了第一个为0，其他都为正无穷大,但正无穷+1会越界为负无穷，所以得转成amount
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        int result = coinChange(coins, amount);
        System.out.println(result);
    }
}
