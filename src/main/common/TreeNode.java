package common;

/**
 * Created by steven on 18-2-8 下午11:02
 * shijia0620@126.com
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
    public static TreeNode getBiTree(){
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(11);
        TreeNode root4 = new TreeNode(13);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(7);
        TreeNode root7 = new TreeNode(2);
        TreeNode root8 = new TreeNode(5);
        TreeNode root9 = new TreeNode(1);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        root5.left = root8;
        root5.right = root9;
        return root;
    }

//    public static void showTree(TreeNode root){}
}
