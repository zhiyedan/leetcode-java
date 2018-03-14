package sj.bluceEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by steven on 18-3-13 下午9:23
 * shijia0620@126.com
 *
 * The solution set must not contain duplicate subsets.
 */
public class L90Subsets2 {

    //TODO 有问题，带解决
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        help(result,new ArrayList<>(),nums,0);
        return result;
    }
    public void help(List<List<Integer>> result, List<Integer> curList, int[] nums, int index){
        result.add(new ArrayList<>(curList));
        for(int i=index; i< nums.length; i++){
            //TODO 越过相同的字符
            if(i>index && nums[i]==nums[i-1]) continue;
            curList.add(nums[i]);
            //TODO error：不是index而是i！！！
            help(result,curList,nums,index+1);
            curList.remove(curList.size()-1);
        }
    }
}
