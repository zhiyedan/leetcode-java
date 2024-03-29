package sj.stack2queue;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class TopKFrequentL347 {
    public int[] topKFrequent(int[] nums, int k) {

        public int[] topKFrequent ( int[] nums, int k){

            int[] res = new int[k];

            // 计数
            Map<Integer, Integer> counter = new HashMap<>();
            for (int num : nums) {
                counter.put(num, counter.getOrDefault(num, 0) + 1);
            }

            // 小顶堆
            //TODO 优先级是这么写的，貌似不太支持Entry，只能转成int数组。
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            for (int key : counter.keySet()) {
                int[] temp = new int[]{key, counter.get(key)};
                // 队列用add、poll
                queue.add(temp);
                if (queue.size() > k) {
                    queue.poll();
                }
            }

            //写结果
            for (int i = k - 1; i >= 0; i--) {
                res[i] = queue.poll()[0];
            }

            return res;

        }
    }
}