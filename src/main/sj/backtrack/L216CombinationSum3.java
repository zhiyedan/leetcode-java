package sj.backtrack;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class L216CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();

        Stack<Integer> stack = new Stack();

        fun(k, n, res, stack, 1);

        return res;
    }

    void fun(int k, int target, List<List<Integer>> res, Stack<Integer> stack, int start) {

        if (stack.size() == k && target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }

        if (k == 0 || stack.size() >= k) {
            return;
        }

        for (int i = start; i <= Math.min(9, target); i++) {
            stack.push(i);
            fun(k, target - i, res, stack, i + 1);
            stack.pop();
        }

    }

    /**
     * 剪枝操作
     * @param k
     * @param n
     * @param startIndex
     * @param sum
     */
    void build(int k, int n, int startIndex, int sum) {

        // TODO 如果当前的和已经大于目标值，直接结束
        if (sum > n || path.size() > k) return;

        if (sum == n && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            build(k, n, i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }

}
