package sj.sort;

/**
 * Created by steven on 18-3-17 上午12:20
 * shijia0620@126.com
 * 快速选择第k大的元素
 */
public class QuickSelect {

    public int solution(int[] nums, int k) {
        if (k > nums.length) return -1;
        return quickSort(nums, k, 0, nums.length - 1);
    }

    public int quickSort(int[] nums, int k, int left, int right) {
        if (left == right) return nums[left];
        int mid = partition(nums, left, right);
        if (mid == k - 1) return nums[k - 1];
        if (mid > k - 1) {
            return quickSort(nums, k, left, mid - 1);
        } else {
            return quickSort(nums, k, mid + 1, right);
        }

    }

    public int partition(int[] nums, int left, int right) {
        if (left >= right) return left;
        int pk = nums[right];
        while (left < right) {
            while (left < right && nums[left] >= pk)
                left++;
            nums[right] = nums[left];
            while (right > left && nums[right] <= pk)
                right--;
            nums[left] = nums[right];
        }
        nums[right] = pk;
        return right;
    }

    public static void main(String[] args) {
        QuickSelect select = new QuickSelect();
        int[] array = new int[]{2, 1, 5, 133, 13, 10, 37};
        for (int i = 1; i <= array.length; i++ ){
            System.out.println(select.solution(array,i));
        }
    }
}
