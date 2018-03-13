package sj.DP;

/**
 * Created by steven on 18-3-12 下午11:51
 * shijia0620@126.com
 * 最长公共子序列
 */
public class LCS {
    public int lcs(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if(lenA == 0 || lenB == 0) return 0;
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[lenA][lenB];
    }

    public static void main(String[] args) {
        LCS a = new LCS();
        System.out.println(a.lcs("asjdfweosdfwe","seofw"));
    }

}
