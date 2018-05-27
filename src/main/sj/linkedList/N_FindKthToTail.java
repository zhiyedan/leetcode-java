package sj.linkedList;

import resources.ListNode;

/**
 * Created by steven on 18-3-23 下午7:27
 * shijia0620@126.com
 *
 * 倒数第k个链表元素
 */
public class N_FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode left = head;
        for(int i=0;i<k;i++){
            // todo 需要判断是否已经为空
            if(head == null)
                return null;
            head = head.next;
        }
        while(head != null){
            head = head.next;
            left = left.next;
        }
        return left;
    }
}
