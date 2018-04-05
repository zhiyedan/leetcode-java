package interview;

import java.util.Arrays;

/**
 * Created by steven on 18-4-3 下午9:27
 * shijia0620@126.com
 */
public class Toutiao {
    //数组元素正负数，要求输出正负间隔，保持原来的顺序，多出来的放在末尾
    public static void zhangyi(int[] nums){
        if(nums.length<1) return;
        int j = -1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]*nums[i-1]>0){
                j=i+1;
                while (j<nums.length && nums[j]*nums[i]>0)
                    j++;
                if(j>=nums.length) break;
                for(int k=j;k>=i+1;k--){
                    int temp = nums[k];
                    nums[k] = nums[k-1];
                    nums[k-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums).toString());
    }

    public static void main(String[] args) {
        zhangyi(new int[]{2,-4,2,-1,-3,5,2,3,-1});
    }
}
