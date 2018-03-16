package sj.sort;


import java.util.Arrays;
import java.util.Stack;

/**
 * Created by steven on 18-3-15 下午7:55
 * shijia0620@126.com
 *
 */
public class QuickSort {
    public void sort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left >= right) return;
        int mid = help(nums,left,right);
        quickSort(nums,left,mid-1);
        quickSort(nums,mid+1,right);
    }

    private int help(int[] nums, int left, int right) {
        int pk = nums[right];
        while (left<right){
            while (left<right && nums[left]<=pk)
                left++;
            nums[right] = nums[left];
            while (right>left && nums[right]>=pk)
                right--;
            nums[left] = nums[right];
        }
        nums[right] = pk;
        return right;
    }

    // TODO 非递归,首先应该想到栈！！！因为递归的思想就是栈
    public void sort2(int[] nums){
        if(nums.length <= 1) return;
//        int left = 0;
//        int right = nums.length-1;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.length-1);
        stack.push(0);
        while (!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            int mid = help(nums,left,right);
            if(mid+1 < right){
                stack.push(right);
                stack.push(mid+1);
            }
            if(mid-1 > left){
                stack.push(mid-1);
                stack.push(left);
            }

        }
    }

    public static void main(String[] args) {
        QuickSort a = new QuickSort();
        int[] array = new int[]{3,1,2,3,23,11,20};
        a.sort2(array);
        System.out.println(Arrays.toString(array));
    }
}
