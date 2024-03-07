package sj.DP;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class L72SubStringMinDistance {
    public int minDistance(String word1, String word2) {

        int m = word2.length();
        int n = word1.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i - 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1],dp[i-1][j]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];

    }
}
