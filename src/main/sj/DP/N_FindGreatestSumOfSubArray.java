package sj.DP;

/**
 * Created by steven on 18-3-24 下午4:40
 * shijia0620@126.com
 *
 * 最大子树组和
 */
public class N_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0) return 0;
        int max = array[0];
        int curSum = array[0];
        for(int i=1;i<array.length;i++){
            curSum = Math.max(curSum+array[i],array[i]);
            max = Math.max(max,curSum);
        }
        return max;
    }
}
