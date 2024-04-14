package sj.backtrack;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class L39CombinationSum1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        fun(candidates, target, res, stack, 0);

        return res;

    }

    void fun(int[] candidates, int target, List<List<Integer>> res, Stack<Integer> stack, int curSum) {

        if (curSum > target) return;

        if (curSum == target) {
            res.add(new ArrayList<>(stack));
        }

        // TODO 错误写法， 这么写对于重复数据无法过滤 121 和 211会被记录两次
        for (int candidate : candidates) {
            stack.push(candidate);
            fun(candidates, target, res, stack, curSum + candidate);
            stack.pop();
        }
    }

    void fun2(int[] candidates, int target, List<List<Integer>> res, Stack<Integer> stack, int curSum, int startIndex) {

        if (curSum > target) return;

        if (curSum == target) {
            res.add(new ArrayList<>(stack));
        }

        // TODO 去重的合理方式，只能从自身及之后开始。画树形图
        for (int i = startIndex; i < candidates.length; i++) {
            int candidate = candidates[i];
            stack.push(candidate);
            fun2(candidates, target, res, stack, curSum + candidate, i);
            stack.pop();
        }
    }
}
