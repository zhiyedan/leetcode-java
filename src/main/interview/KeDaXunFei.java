package main.interview;

import java.util.Scanner;

/**
 * Created by steven on 18-4-19 下午7:49
 * shijia0620@126.com
 */
public class KeDaXunFei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] array = new int[count];
        int sum = 0;
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }
        int target = sum >> 1;
        target = (target*2==sum)?target:target+1;
        int halfCount = count >> 1;
        int[] dp = new int[sum + 1];
//        dp[0] = 1;
        for (int num : array) {
            for (int i = sum; i >= num; i--) {
                //todo 状态转移方程考虑个数相差不超过1,这个是硬性指标！！！
                dp[i] = minHalf(dp[i - num] + 1, dp[i], halfCount);

            }
        }
        for (int i = target; i >= 0; i--) {
            if (Math.abs(dp[i] * dp[i] - count) <= 1) {
                System.out.println("" + i + " " + (sum - i));
                return;
            }
        }

    }

    public static int minHalf(int a, int b, int half) {
        return (Math.abs(a - half) < Math.abs(b - half)) ? a : b;
    }
}
