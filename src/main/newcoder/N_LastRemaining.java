package newcoder;

import common.ListNode;

/**
 * Created by steven on 18-3-27 下午5:34
 * shijia0620@126.com
 * 圆圈中最后一个数的下标,n个数字，每第m个被淘汰,求幸存者下标
 */
public class N_LastRemaining {
    public static int solution(int n, int m){
        ListNode headNode = new ListNode(0);
        ListNode curNode = headNode;
        for(int i=1; i<n; i++){
            curNode.next = new ListNode(i);
            curNode = curNode.next;
        }
        curNode.next = headNode;
        int index = 0;
        while (headNode.next != headNode){
            index++;
            if(index == m){
                headNode.next = headNode.next.next;
            }
        }
        return headNode.val;
    }

    public static void main(String[] args) {
        System.out.println(solution(3,2));
    }

}
