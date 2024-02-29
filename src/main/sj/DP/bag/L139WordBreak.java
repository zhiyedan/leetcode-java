package sj.DP.bag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= i) {
                    dp[i] = dp[i] || dp[i - word.length()] && isMatch(s,word,i);
                }
            }
        }
        return dp[s.length()];
    }

    private static boolean isMatch(String origin, String target, int endIndex) {
        return origin.substring(endIndex - target.length(), endIndex).equals(target);
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));
        String s = "leetcode";
        boolean result = wordBreak(s, wordDict);
        System.out.println(result);
    }
}
