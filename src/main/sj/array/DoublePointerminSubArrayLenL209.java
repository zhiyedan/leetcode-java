package sj.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
 * 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 */
public class DoublePointerminSubArrayLenL209 {

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int sum = 0;

        int answer = Integer.MAX_VALUE;

        // TODO 做了好几次都不对，没想清楚怎么移动指针，一个为主，另一个逐渐靠近！end为主，end不能越界，start靠近。
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                answer = Math.min(answer, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;

    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, a));
    }
}
