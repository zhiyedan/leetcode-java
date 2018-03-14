package sj.bluceEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 18-3-13 下午9:45
 * shijia0620@126.com
 * <p>
 * Given a collection of distinct numbers, return all possible permutations.
 */
public class L46permute {

    // TODO 依次插入新元素
    public List<List<Integer>> permute(int[] nums) {
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


}
