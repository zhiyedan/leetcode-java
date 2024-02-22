package sj.DP;

/**
 * Created by steven on 18-2-24 下午4:22
 * shijia0620@126.com
 * <p>
 * BST 的个数
 */
public class L96NumTrees {
    //    dp[3] = dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0]
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

}
