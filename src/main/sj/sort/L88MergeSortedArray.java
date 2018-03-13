package sj.sort;

/**
 * Created by steven on 18-2-25 下午4:11
 * shijia0620@126.com
 * <p>
 * merge B into A
 */
public class L88MergeSortedArray {
    //TODO 对于array的移动，选择从后往前移，这样时间复杂度为O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int aIndex = m - 1;
        int bIndex = n - 1;
        while (index >= 0) {
            while (aIndex >= 0 && bIndex >= 0)
                nums1[index--] = (nums1[aIndex] > nums2[bIndex]) ? nums1[aIndex--] : nums2[bIndex--];
            while (aIndex >= 0) nums1[index--] = nums1[aIndex--];
            while (bIndex >= 0) nums1[index--] = nums2[bIndex--];
        }
    }

    //TODO 上面代码有两处可以优化，第一index不用加循环，第二，aindex不用加循环，因为如果b已经插入进去，则a的头部不需要改变。
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int aIndex = m - 1;
        int bIndex = n - 1;
        while (aIndex >= 0 && bIndex >= 0)
            nums1[index--] = (nums1[aIndex] > nums2[bIndex]) ? nums1[aIndex--] : nums2[bIndex--];
        while (bIndex >= 0) nums1[index--] = nums2[bIndex--];
    }
}
