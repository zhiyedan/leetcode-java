package sj.sort;

import resources.MyUtil;

import java.util.Arrays;

/**
 * Created by steven on 18-3-15 下午9:26
 * shijia0620@126.com
 */
public class HeapSort {

    public void sort(int[] nums) {
        if (nums.length <= 1) return;
        int len = nums.length;
        int mid = (len - 2) >> 1;
        //  首先构造大顶堆
        for (int i = mid; i >= 0; i--) {
            buileMaxHeap(nums,i);
        }
        int end = len-1;
        MyUtil.swap(nums,0,end--);
        while (end>0){
            buileMaxHeap(nums,0);
            MyUtil.swap(nums,0,end--);
        }

    }

    // todo 建立大顶堆
    public void buileMaxHeap(int[] nums, int fatherIndex) {
        int leftSon = fatherIndex * 2 + 1;
        int rightSon = fatherIndex * 2 + 2;
        int maxIndex = fatherIndex;
        if(leftSon<nums.length && nums[leftSon]>nums[fatherIndex])
            maxIndex = leftSon;
        // TODO 很巧秒的用maxIndex找最大下标
        if(rightSon<nums.length && nums[rightSon] > nums[maxIndex])
            maxIndex = rightSon;
        if(maxIndex != fatherIndex){
            MyUtil.swap(nums,fatherIndex,maxIndex);
            buileMaxHeap(nums,maxIndex);
        }
    }

    public static void main(String[] args) {
        HeapSort a = new HeapSort();
        int[] nums = new int[]{1,2,6,2,23,2};
        a.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
