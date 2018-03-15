package resources;

/**
 * Created by steven on 18-3-15 下午8:56
 * shijia0620@126.com
 */
public class MyUtil {
    public static void swap(int[] nums, int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
