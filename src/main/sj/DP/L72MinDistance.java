package sj.DP;

/**
 * Created by steven on 18-2-12 下午7:09
 * shijia0620@126.com
 */
public class L72MinDistance {
    //TODO： 错误，少了一行一列，下标为0代表字符串的第一个元素，因此失败
    public int minDistance1(String word1, String word2) {
        int m = word2.length();
        int n = word1.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Math.max(i,j);
                }else {
                     dp[i][j] = Math.min( dp[i-1][j-1] + ((word1.charAt(i) == word2.charAt(j))?0:1),
                                Math.min(dp[i-1][j],dp[i][j-1]) + 1);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Math.max(i,j);
                }else {
                    dp[i][j] = Math.min( dp[i-1][j-1] + ((word1.charAt(i-1) == word2.charAt(j-1))?0:1),
                            Math.min(dp[i-1][j],dp[i][j-1]) + 1);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
