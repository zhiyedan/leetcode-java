package sj.doublePointer;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElementL27 {
    /**
     * 暴力解法 n方
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElementForce(int[] nums, int val) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < n; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                n--;
            }
        }
        return n;
    }

    /**
     * 快慢指针，画在纸上最好是上下两个分开，不要都放在下面。
     * 快慢指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {

        int n = nums.length;
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
