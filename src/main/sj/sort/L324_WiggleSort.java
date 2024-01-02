package sj.sort;

import common.Util;

import java.util.Arrays;

/**
 * Created by steven on 18-4-15 下午9:10
 * shijia0620@126.com
 * <p>
 * Given an unsorted array nums,
 * 1.  reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]
 * 2.  reorder it such that nums[0] < nums[1] > nums[2] < nums[3]
 */
public class L324_WiggleSort {

    public static void wiggleSort1(int[] array) {
        if (array.length < 3) return;
        for (int i = 1; i < array.length - 1; i++) {
            if ((array[i] - array[i - 1]) * (array[i + 1] - array[i]) > 0) {
                Util.swap(array, i, i + 1);
            }
        }
    }

    public static void wiggleSort2(int[] array) {
        //先sort,中位数往前插入到奇数位置，尾巴的数字顺序插入到偶数位置。
        Arrays.sort(array);
        int[] temp = new int[array.length];
        int odd = (array.length - 1) >> 1;
        int even = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            temp[i] = (i & 1) == 0 ? array[odd--] : array[even--];
        }
        for(int i=0 ;i<temp.length;i++){
            array[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 1, 4, 1, 2, 5};
        wiggleSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
