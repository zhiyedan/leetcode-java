package sj.DP;

/**
 * 常规版本爬楼梯可能性
 */
public class ClimbStairs {

    /**
     * 常规方式
     *
     * @param n
     */
    public static int fun1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static int fun2(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2, temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * @param n 总台阶数
     * @param m 一次最多可以跨越台阶数
     * @return
     */
    public static int fun3(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i >= j){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(ClimbStairs.fun1(5));
        System.out.println(ClimbStairs.fun2(5));
    }
}
