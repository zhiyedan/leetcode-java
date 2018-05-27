package sj.linkedList;

import resources.ListNode;

/**
 * Created by steven on 18-3-29 下午7:58
 * shijia0620@126.com
 *
 * 判断链表是否有环路
 */
public class N_HasCycle {
    public boolean hasCycle(ListNode head){
        if(head == null) return false;
        ListNode slow = head;
        ListNode quick = head.next;
        while (quick != null && quick.next != null){
            if(slow == quick)return true;
            slow = slow.next;
            quick = quick.next.next;
        }
        return false;
    }
}
