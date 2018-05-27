package main.sj.DP;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by steven on 18-4-1 下午4:41
 * shijia0620@126.com
 * 给定一个非负数组，给每个数字加正负号，得到sum为target，求共有多少种组合方式。
 */
public class L494_targetSum {

    //todo 超时
    public int findTargetSumWays(int[] nums,int s){
        int sum = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        if(s>sum || (s+sum) %2 != 0) return 0;
        int target = (s+sum)>>1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i=0; i<nums.length;i++){
            ArrayList<Integer> newList = new ArrayList<>();
            for(int num: list){
                newList.add(num+0);
                newList.add(num+nums[i]);
            }
            list = newList;
        }
        for(int i: list){
            if(i==target) result++;
        }
        return result;
    }

    //todo dp 思想
    public int findTargetSumWays2(int[] nums,int s) {
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (s > sum || (s + sum) % 2 != 0) return 0;
        int target = (s + sum) >> 1;
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int num : nums){
            for(int index = target; index>=num; index--){
                dp[index] += dp[index-num];
            }
        }
        return dp[target];
    }
}
