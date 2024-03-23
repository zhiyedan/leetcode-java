package sj.stack;

import java.util.*;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class TrapL42 {

    /**
     * 单调栈思路
     *
     * @param height
     * @return
     */
    public static int trapStack(int[] height) {

        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curNum = stack.pop();
                if (!stack.isEmpty()) {
                    int diffHeight = Math.min(height[i], height[stack.peek()]) - height[curNum];
                    int weight = i - stack.peek() - 1;
                    result += diffHeight * weight;
                }
            }
            stack.push(i);
        }

        return result;
    }

    /**
     * 暴力求解，竖向球每个item作为底能容纳的雨水。
     *
     * @param height
     * @return
     */
    public static int trapForce(int[] height) {

        int result = 0;

        for (int i = 1; i < height.length - 1; i++) {
            // 左边最大值
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            // 右边最大值
            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int diff = Math.min(rightMax, leftMax) - height[i];
            diff = diff > 0 ? diff : 0;
            result += diff;
        }

        return result;
    }

    /**
     * 动态规划，找到左边最高的，右边最高的。
     *
     * @param height
     * @return
     */
    public static int trapDP(int[] height) {

        int result = 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                result += min - height[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapDP(height));
    }
}
