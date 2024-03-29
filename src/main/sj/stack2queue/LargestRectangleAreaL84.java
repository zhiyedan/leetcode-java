package sj.stack2queue;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRectangleAreaL84 {

    /**
     * 暴力解法，超时
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaForce(int[] heights) {

        int result = 0;

        for (int i = 0; i < heights.length; i++) {
            // 左边最后一个比它大的index
            int leftIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    leftIndex = j;
                } else {
                    break;
                }
            }

            // 右边最后一个比它大的index
            int rightIndex = i;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {
                    rightIndex = j;
                } else {
                    break;
                }
            }

            int width = Math.max(rightIndex - leftIndex + 1, 1);

            result = Math.max(result, width * heights[i]);
        }

        return result;
    }

    /**
     * 双指针，跳法很有讲究，存的是第一个比它小的下标，如果遍历的item比它大，则下标直接跳转到这个元素存储的最小下标。
     */
    public int largestRectangleAreaDoublePointer(int[] heights) {

        int result = 0;

        int n = heights.length;

        int[] leftIndex = new int[n];
        int[] rightIndex = new int[n];

        leftIndex[0] = -1;
        rightIndex[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) {
                t = leftIndex[t];
            }
            leftIndex[i] = t;
        }

        for (int i = n - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < n && heights[t] >= heights[i]) {
                t = rightIndex[t];
            }
            rightIndex[i] = t;
        }

        for (int i = 0; i < n; i++) {
            int width = rightIndex[i] - leftIndex[i] - 1;
            result = Math.max(result, width * heights[i]);
        }

        return result;
    }

}
