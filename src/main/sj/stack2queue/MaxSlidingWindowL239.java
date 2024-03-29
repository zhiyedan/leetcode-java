package sj.stack2queue;

import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindowL239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> queue = new LinkedList<>();

        int n = nums.length;

        int[] result = new int[n - k + 1];

        // 处理前k个数据
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        result[0] = nums[queue.peekFirst()];

        // 处理后面的数据
        for (int i = k; i < n; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            while (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            result[i - k + 1] = nums[queue.peekFirst()];
        }

        return result;
    }

    /**
     * 抄答案
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindowStd(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7,2,4};
        int[] a = maxSlidingWindowStd(array,2);
        int[] b = maxSlidingWindow(array,2);
    }

}
