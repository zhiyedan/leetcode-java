package sj.array;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 重复元素：左边第一个位置，右边最后一个位置
 */
public class BinSearchRangeL34 {

    public static int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];


        int left = searchLeftFirst(nums,target);
        int right = searchRightLast(nums,target);

        result[0] = left;
        result[1] = right;

        return result;

    }


    public static int searchLeftFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target && (mid == 0 || mid - 1 >= 0 && nums[mid - 1] < target)) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int searchRightLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target && (mid == nums.length-1 || mid + 1 < nums.length && nums[mid + 1] > target)) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,8,8,8,10};
        System.out.println(searchLeftFirst(nums, 7));
        System.out.println(searchLeftFirst(nums, 8));
        System.out.println(searchRightLast(nums, 7));
        System.out.println(searchRightLast(nums, 8));
    }

}
