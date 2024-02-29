package sj.DP.bag;
import java.util.Arrays;

public class L279NumSquares {
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        int weight = (int) Math.sqrt(n);

        for (int i = weight; i >= 1; i--) {
            int curNum = i * i;
            for (int j = curNum; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - curNum] + 1);
                if (j == n && dp[n] < n) return dp[n];
            }
        }
        return dp[n];
    }
}
