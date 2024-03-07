package sj.DP;

/**
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，
 * 结果需要对 109 + 7 取模。
 */
public class L115SubArrayNumDistinct {
    public static int numDistinct(String origin, String target) {

        int m = target.length();
        int n = origin.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= m; i++) {
            int curMax = 0;
            for (int j = 1; j <= n; j++) {
                if (target.charAt(i - 1) == origin.charAt(j - 1)) {
                    dp[i][j] = dp[i][j-1] + dp[i - 1][j - 1];
                    curMax = Math.max(curMax, dp[i][j]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
            if (curMax < 1) return 0;
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        int result = numDistinct("babgbag", "bag");
        System.out.println(result);
    }
}
