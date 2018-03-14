package sj.bluceEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by steven on 18-3-14 下午11:17
 * shijia0620@126.com
 */
public class L47Permutations2 {
    // 不能有重复的字串
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        help(result, new ArrayList<>(), nums,new boolean[nums.length]);
        return result;
    }

    private void help(List<List<Integer>> result, ArrayList<Integer> curList, int[] nums, boolean[] used) {
        if (curList.size() == nums.length) {
            result.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i>0 && nums[i] == nums[i-1] && !used[i])) continue;
            curList.add(nums[i]);
            used[i] = true;
            help(result, curList, nums,used);
            used[i] = false;
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        L47Permutations2 a = new L47Permutations2();
        a.permuteUnique(new int[]{1,2,2});
    }
}
