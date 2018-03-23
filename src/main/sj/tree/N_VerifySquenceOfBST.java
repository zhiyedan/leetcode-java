package sj.tree;

/**
 * Created by steven on 18-3-24 上午12:51
 * shijia0620@126.com
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
 */
public class N_VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0) return false;
        return cursive(sequence,0,sequence.length-1);
    }
    public boolean cursive(int[] array, int left, int right){
        if(left>=right) return true;
        //找到比root节点小的最右节点
        int index = right-1;
        while(index>=left && array[index]>array[right])
            index--;
        for(int i=index-1;i>=left;i--){
            if(array[i]>array[right])
                return false;
        }
        return cursive(array,left,index) && cursive(array,index+1,right-1);
    }
}
