package sj.array;

/**
 * 二分查找涉及的很多的边界条件，逻辑比较简单，但就是写不好。
 * 例如到底是 while(left < right) 还是 while(left <= right)，
 * 到底是right = middle呢，还是要right = middle - 1呢？
 *
 * 大家写二分法经常写乱，主要是因为对区间的定义没有想清楚，区间的定义就是不变量。
 * 要在二分查找的过程中，保持不变量，就是在while寻找中每一次边界的处理都要坚持根据区间的定义来操作，这就是循环不变量规则。
 */
public class BinSearchL704 {

    /**
     * 左闭右闭式写法
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
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
}
