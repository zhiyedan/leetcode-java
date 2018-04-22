package sj.array;

import java.util.Stack;

/**
 * Created by steven on 18-3-24 下午3:28
 * shijia0620@126.com
 * <p>
 * 找出出现的次数超过数组长度的一半的数字，没有返回0
 */
public class N_MoreThanHalfNum_Solution {

    //todo 打雷的思想，一样则加，不一样则减
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;
        int winner = array[0];
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                winner = array[i];
                count++;
            } else if (array[i] == winner) {
                count++;
            } else {
                count--;
            }
        }
        count = getCount(array, winner);
        return count * 2 > array.length ? winner : 0;
    }

    //todo 判断是否为真的擂主
    private int getCount(int[] array, int winner) {
        int count;
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == winner)
                count++;
        }
        return count;
    }

    //todo 同样的思路，两个元素不太相同则出栈
    public int HalfNum(int[] array) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty() || stack.peek() == array[i]) stack.push(array[i]);
            else stack.pop();
        }
        if (stack.isEmpty() || getCount(array, stack.peek()) * 2 > array.length) return -1;
        return stack.peek();
    }
}
