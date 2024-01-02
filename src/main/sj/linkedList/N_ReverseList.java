package sj.linkedList;

import common.ListNode;

/**
 * Created by steven on 18-3-23 下午7:33
 * shijia0620@126.com
 *
 * 反转链表
 */
public class N_ReverseList {
    //todo 借助新加的头节点，每次都往其后面插入。
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = head.next;
        head.next = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }

    // todo 递归方法
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        ListNode temp = newHead;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return newHead;
    }
}
