package sj.search;

/**
 * Created by steven on 18-3-7 下午7:52
 * shijia0620@126.com
 * 找区间，没有找到，则返回[-1,-1]
 */
public class L34searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int start = 0;
        int end = nums.length;
        // 找左起点
        while (start<end){
            int mid = (start+end)>>1;
            if(nums[mid] < target) start = mid + 1;
            else end = mid;
        }
        if(nums[start] != target) return result;
        result[0] = start;

        // TODO 找最右端结尾 ------不对，陷入死循环。。。。
        end = nums.length-1;
        while (start < end){
            int mid = (start + end)>>1 + 1;
            if(nums[mid] > target) end = mid-1;
            else start = mid;
        }
        result[1] = end;
        return result;
    }

    //TODO 最佳答案
    public int[] searchRange2(int[] nums, int target) {
        int left = search(nums,target);
        if(left >= nums.length || nums[left] != target)
            return new int[]{-1,-1};
        int right = search(nums,target+1)-1;
        return new int[]{left,right};
    }
    //找左起点
    public int search(int[] nums, int target){
        int low = 0; int high = nums.length;
        while (low<high){
            int mid = (high + low) >> 1;
            if(nums[mid] < target) low = mid+1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        L34searchRange a = new L34searchRange();
        System.out.println(a.searchRange2(new int[]{2,2},3));
    }
}
