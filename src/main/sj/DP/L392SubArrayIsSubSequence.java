package sj.DP;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class L392SubArrayIsSubSequence {
    public static boolean isSubsequence(String s, String t) {

        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean curResult = false;
            for (int j = index; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    curResult = true;
                    index = j + 1;
                    break;
                }
            }
            if (!curResult) {
                return false;
            }
        }
        return true;
    }

    public static boolean doublePoint(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();

    }

    public static boolean dp(String s, String t) {

        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        int maxCount = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxCount = Math.max(maxCount, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            if (maxCount < i) return false;
        }

        return true;

    }

    public static void main(String[] args) {
        boolean result = doublePoint("ac", "ahbgdc");
        System.out.println(result);
    }
}
