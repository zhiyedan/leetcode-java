package sj.sort;

import java.util.*;

/**
 * Created by steven on 18-3-24 下午4:06
 * shijia0620@126.com
 * <p>
 * 输入n个整数，找出其中最小的K个数
 */
public class N_GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //todo priorityQueue 并不是排好序的，只是大顶堆，只保证堆顶元素为最值。
        System.out.println(Arrays.toString(pq.toArray()));
        for (int i = 0; i < input.length; i++) {
            if(i<k)
                pq.offer(input[i]);
            else if (input[i] < pq.peek()) {
                pq.poll();
                pq.offer(input[i]);
            }
        }
        return new ArrayList<>(pq);
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = GetLeastNumbers_Solution(new int[]{4, 1, 3, 7, 89, 12, 30}, 5);
        System.out.println(Arrays.toString(result.toArray()));
       /* PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(5);
        priorityQueue.offer(3);
        priorityQueue.offer(4);
        System.out.println(Arrays.toString(priorityQueue.toArray()));*/
    }
}
