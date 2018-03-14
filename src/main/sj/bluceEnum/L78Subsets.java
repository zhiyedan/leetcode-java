package sj.bluceEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by steven on 18-3-13 下午5:09
 * shijia0620@126.com
 * <p>
 * possible subsets (the power set).
 */
public class L78Subsets {

    // 二进制法，前提集合元素不超过int位数，即32个
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // i 代表具体的数值
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> list = new ArrayList<>();
            //TODO 位操作
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) == 1) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }


    // 递归方法，更容易理解，每次都翻一倍
    public List<List<Integer>> subsets2(int[] nums) {
        return recursive(nums, 0);

    }

    public List<List<Integer>> recursive(int[] nums, int index) {
        if (index == nums.length - 1) {
            List<List<Integer>> listSetList = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(nums[index]);
            listSetList.add(list);
            listSetList.add(new ArrayList<>());
            return listSetList;
        }
        List<List<Integer>> listSet = recursive(nums, index + 1);
        int listSize = listSet.size();
        System.out.println(listSize);
        for (int i = 0; i < listSize; i++) {
            List<Integer> newList = new ArrayList<>(listSet.get(i));
            newList.add(nums[index]);
            listSet.add(newList);
        }
        return listSet;
    }

    //TODO 网上最佳,按照顺序 1, 12, 123 , 13, 2, 23 3,一条道走到黑，然后再走，类似于树
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> curList, int[] nums, int start){
        //TODO 这样curList不会发生改变。
        list.add(new ArrayList<>(curList));
        for(int i = start; i<nums.length;i++){
            curList.add(nums[i]);
            backtrack(list,curList,nums,i+1);
            curList.remove(curList.size()-1);
        }
    }
}
