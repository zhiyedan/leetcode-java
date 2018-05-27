package newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by steven on 18-3-31 下午8:32
 * shijia0620@126.com
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
 */
public class N_maxInWindows {

    /* todo 思路清晰
    用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
    1.判断当前最大值是否过期
    2.新增加的值从队尾开始比较，把所有比他小的值丢掉
    */
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length == 0 || size > num.length || size<1) return list;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int right = 0; right < num.length; right++) {
            int left = right-size+1;
            if(queue.isEmpty()) queue.add(right);
            // todo 判断头是否过期
            else if(left>queue.getFirst()) queue.removeFirst();

            //todo 将所有小于right的移除队列。
            while (!queue.isEmpty() && num[right]>=num[queue.getLast()]) queue.removeLast();
            queue.add(right);
            if(right>=size-1) list.add(num[queue.getFirst()]);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
