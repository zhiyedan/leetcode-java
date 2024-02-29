package sj.DP;

import common.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class L337Rob3 {

    // TODO 递归版本，会超时
    public int rob(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int a = rob(root.left) + rob(root.right);
        //TODO 三元表达式的优先级比+低，会报错！！！
        int b = root.val
                + (root.left != null ? rob(root.left.left) + rob(root.left.right) : 0)
                + (root.right != null ? rob(root.right.left) + rob(root.right.right) : 0);

        return Math.max(a, b);
    }

    public int rob2(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return robHelper(root, map);
    }

    private int robHelper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;

        if (map.containsKey(root)) return map.get(root);

        // 计算包含当前节点的结果
        int robRoot = root.val +
                (root.left != null ? robHelper(root.left.left, map) + robHelper(root.left.right, map) : 0) +
                (root.right != null ? robHelper(root.right.left, map) + robHelper(root.right.right, map) : 0);

        // 计算不包含当前节点的结果
        int robChild = robHelper(root.left, map) + robHelper(root.right, map);

        // 比较包含和不包含当前节点的结果，更新缓存
        int result = Math.max(robRoot, robChild);
        map.put(root, result);

        return result;
    }

}
