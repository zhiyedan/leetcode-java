package sj.DP;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class L647Palindrome {

    /**
     * dp思路：如果两个边上的字母相同，则是否为回文 等价于 中间子串是否为回文。
     * 这里需要注意一个元素和两个元素相同都是回文
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {

        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    //TODO 如果差一个以内，则直接为true
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) count++;
            }
        }
        return count;

    }

    /**
     * 双指针法：注意：可以是一个中心点，也可以是两个中心点
     *
     * @param s
     * @return
     */
    public static int countSubstringDoublePointer(String s) {

        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += fun(s, i, i);
            System.out.println("i:"+i+" result:"+ count);
            count += fun(s, i, i + 1);
            System.out.println("i:"+i+" result:"+ count);
        }
        return count;
    }

    static int fun(String s, int start, int end) {

        int count = 0;
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start--) == s.charAt(end++)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstringDoublePointer("fdsklf"));
    }

}
