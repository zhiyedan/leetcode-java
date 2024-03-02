package sj.DP;

import java.util.Arrays;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class L1143SubArrayLCS {

    public static int longestCommonSubsequence(String text1, String text2) {

        int result = 0;
        int[] dp = new int[text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {

                    // TODO 这所以这么写，还是对dp数据含义没有深刻理解，如果把他定义为截至目前最大，就不用每次遍历了。
                    int formerMax = 0;
                    for (int k = 0; k < j; k++) {
                        formerMax = Math.max(formerMax, dp[k]);
                    }
                    dp[j] = formerMax + 1;
                    result = Math.max(result, dp[j]);
                }
                // 打印数组
                System.out.println(String.format("cur index:%d,%d, result:%s", i, j, Arrays.toString(dp)));
            }
        }
        return result;

    }

    int dp2Array(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        String text1 = "abcba";
        String text2 = "abcbcba";
        int result = longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }
}
