package sj.sort;

import common.Util;

/**
 * Created by steven on 18-3-1 下午8:09
 * shijia0620@126.com
 * <p>
 * 0,1,2分别代表red,white,blue,将数组按照顺序排序，要求只扫描一次数组
 */
public class L75sortColors {
    //TODO 首尾双指针
    public void sortColors1(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int curIndex = 0;
        // TODO 这样的话是结束不了的。。。。。因为最后会一直等于2,陷入死循环
//        while (curIndex < nums.length) {
        while (curIndex <= blue) {
            if (nums[curIndex] == 0) {
//                Collections.swap(Arrays.asList(nums), red++, curIndex++);
                Util.swap(nums, red++, curIndex++);
            } else if (nums[curIndex] == 2) {
                Util.swap(nums, curIndex, blue);
            } else {
                curIndex++;
            }
        }
    }

    //  TODO 简洁版本
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            while (nums[i] == 0 && i > red)
                Util.swap(nums, i, red++);
            while (nums[i] == 2 && i < blue)
                Util.swap(nums, i, blue--);
        }
    }


    public static void main(String[] args) {
        L75sortColors a = new L75sortColors();
        a.sortColors(new int[]{1, 2, 0, 2, 1, 1, 0});
    }


}
