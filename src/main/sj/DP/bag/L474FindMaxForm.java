package sj.DP.bag;

public class L474FindMaxForm {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroCount = countChar(str, '0');
            int oneCount = countChar(str, '1');
            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeroCount][j - oneCount]);
                }
            }
        }
        return dp[m][n];
    }

    private static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            if (item == ch) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));
    }
}
