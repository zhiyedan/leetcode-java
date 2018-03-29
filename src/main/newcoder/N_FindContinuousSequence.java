package newcoder;

import java.util.ArrayList;

/**
 * Created by steven on 18-3-27 下午3:52
 * shijia0620@126.com
 * 返回所有和为s的连续整数序列
 */
public class N_FindContinuousSequence {
    // todo 思路：双指针，小于s则big右移，大于ssamll右移
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = 1;
        int right = 2;
        int end = (sum+1)>>1;
        int curSum = left + right;
        while (left<right && right<=end){
            if(curSum == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=left;i<=right;i++){
                    list.add(i);
                }
                result.add(list);
                // todo 如果没有后序处理会陷入死循环。。。
                curSum -= left;
                left ++;
            }else if(curSum < sum){
                right++;
                curSum += right;
            }else {
                curSum -= left;
                left++;
            }
        }
        return result;
    }
}
