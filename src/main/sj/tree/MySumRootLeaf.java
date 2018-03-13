package sj.tree;

import resources.TreeNode;

/**
 * Created by steven on 18-2-25 下午3:55
 * shijia0620@126.com
 * 求所有root到leaf组成的数字之和
 */
public class MySumRootLeaf {
    int sum;

    public int sumNum(TreeNode root) {
        sum = 0;
        helpFun(root, 0);
        return sum;
    }

    public void helpFun(TreeNode root, int lastNum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += lastNum * 10 + root.val;
            return;
        }
        helpFun(root.left, lastNum * 10 + root.val);
        helpFun(root.right, lastNum * 10 + root.val);
    }

    // TODO 更好的解法,这里有一点需要深刻理解：输入参数sum是上面传下来的，返回的是计算出的sum，两者之间没有任何关系。
    public int dsf(TreeNode root, int sum) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return sum*10 + root.val;
        return dsf(root.left,sum*10 + root.val) + dsf(root.right,sum*10+root.val);
    }

}
