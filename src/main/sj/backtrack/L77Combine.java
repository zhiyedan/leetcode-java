package sj.backtrack;

import java.util.*;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class L77Combine {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        fun(1, n, k, res, stack);

        return res;

    }

    void fun(int start, int end, int k, List<List<Integer>> res, Stack<Integer> stack) {

        if (k == stack.size()) {
            res.add(new ArrayList<>(stack));
            return;
        }

        // TODO 剪枝操作，去掉那些不可能的集合，加速收敛。 i <= end - (k - stack.size()) + 1
        for (int i = start; i <= n; i++) {
            stack.push(i);
            fun(i + 1, end, k, res, stack);
            stack.pop();
        }

    }

}
