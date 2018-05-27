package sj.bluceEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 18-3-13 下午9:45
 * shijia0620@126.com
 * <p>
 * Given a collection of distinct numbers, return all possible permutations.
 *
 */
public class L46permute {

    // TODO 全排序问题   依次插入新元素
    public List<List<Integer>> permute1(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        return help(nums, nums.length - 1);
    }

    private List<List<Integer>> help(int[] nums, int index) {
        if (index == 0) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        List<List<Integer>> formerList = help(nums, index - 1);
        List<List<Integer>> newResult = new ArrayList<>();
        for (List<Integer> list : formerList) {
            for (int i = 0; i <= index; i++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i, nums[index]);
                newResult.add(newList);
            }
        }
        return newResult;
    }

    // TODO 上面的方法可以用非递归去做！！！
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        List<Integer> newList = new ArrayList<>();
        newList.add(nums[0]);
        result.add(newList);
        for (int index = 1; index < nums.length; index++) {
            List<List<Integer>> newResult = new ArrayList<>();
            for (List<Integer> eachList : result) {
                for (int j = 0; j <= index; j++) {
                    List<Integer> innerList = new ArrayList<>(eachList);
                    innerList.add(nums[index]);
                    newResult.add(innerList);
                }
            }
            result = newResult;
        }

        return result;
    }

    //TODO 时间复杂度为 n*n!
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        backtrack(result,new ArrayList<>(),nums);
        return result;
    }

    public void backtrack(List<List<Integer>> result,List<Integer> tempList,int[] nums){
        if(tempList.size() == nums.length){
            //TODO 这样写返回的都为空，因为只有一个实例对象
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0; i< nums.length; i++){
            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            backtrack(result,tempList,nums);
            tempList.remove(tempList.size()-1);
        }
    }

}
