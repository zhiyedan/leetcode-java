package sj.DP.bag;

import java.util.Arrays;

public class OriginBag {

    public static int slideArrayBag(int capacity, int[] weight, int[] value) {

        int n = weight.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < n; i++) {
            System.out.println("cur i:" + i);
            // TODO 从后往前很关键！！！
            for (int j = capacity; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j - weight[i]] + value[i], dp[j]);
            }

        }
        return dp[capacity];
    }


    // TODO 不能正序遍历，否则物品0就不会重复加入多次！！！01背包变成了完全背包。
    public static int slideArrayBagWrong(int capacity, int[] weight, int[] value) {

        int n = weight.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j - weight[i]] + value[i], dp[j]);
                }
            }
        }
        return dp[capacity];
    }

    public static int originBag(int capacity, int[] weight, int[] value) {
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 打印dp数组
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        slideArrayBag(bagSize, weight, value);
    }

}
