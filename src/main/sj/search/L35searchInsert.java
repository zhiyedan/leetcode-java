package sj.search;

/**
 * Created by steven on 18-3-1 下午10:54
 * shijia0620@126.com
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order
 *
 * 如果没有，返回应该插入的位置
 */
public class L35searchInsert {
    // 没有 == 版本
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        //TODO 注意high本身靠右，所以mid也是偏右的。
        int high = nums.length;
        //TODO 没有==的坏处是可能多出log(n)次查找。。。。
        while (low<high){
            int mid = (low+high)>>1;
            if(nums[mid] < target)
                //low会出边界
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
    // 有 == 版本
    public int searchInsert2(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        //TODO 一定要注意，这里应该是 '<=' 而非 '<'
        while (begin<=end){
            //TODO mid = (right - left) / 2 + left; this will prevent overflow.
            int mid = (begin+end)>>1;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) begin = mid+1;
            else end = mid-1;
        }
        return begin;
    }
}
