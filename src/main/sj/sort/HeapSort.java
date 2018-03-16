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
        int end = nums.length-1;
        int mid = (end - 1) >> 1;
        //  首先构造大顶堆
        for (int i = mid; i >= 0; i--) {
            buileMaxHeap(nums,i,nums.length);
        }
        MyUtil.swap(nums,0,end--);
        while (end>0){
            buileMaxHeap(nums,0,end+1);
            MyUtil.swap(nums,0,end--);
        }

    }

    // todo 建立大顶堆,一定要注明结尾，这个在sort的时候会用到。（不包括end）
    public void buileMaxHeap(int[] nums, int curIndex,int end) {
        int leftSon = curIndex * 2 + 1;
        int rightSon = curIndex * 2 + 2;
        int maxIndex = curIndex;
        if(leftSon<end && nums[leftSon]>nums[curIndex])
            maxIndex = leftSon;
        // TODO 很巧秒的用maxIndex找最大下标
        if(rightSon<end && nums[rightSon] > nums[maxIndex])
            maxIndex = rightSon;
        if(maxIndex != curIndex){
            MyUtil.swap(nums,curIndex,maxIndex);
            buileMaxHeap(nums,maxIndex,end);
        }
    }

    public static void main(String[] args) {
        HeapSort a = new HeapSort();
        int[] nums = new int[]{1,42,6,12,23,2};
        a.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
