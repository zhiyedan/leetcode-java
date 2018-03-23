package sj.stack;

import resources.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by steven on 18-3-24 上午12:15
 * shijia0620@126.com
 *
 * 第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列
 */
public class N_IsPopOrder {

    //todo 有思考的难度
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0, j=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            //todo 是循环而非if判断
            while (j<popA.length && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
