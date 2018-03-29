package sj.linkedList;

import resources.ListNode;

/**
 * Created by steven on 18-3-29 下午8:48
 * shijia0620@126.com
 *
 * 删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class N_deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode pre = newHead;
        ListNode cur = pHead;
        while (cur != null){
            while (cur.next!=null && cur.next.val == cur.val)
                cur =cur.next;
            if(cur == pre.next){
                //pre向后移动
                pre = cur;
                cur =cur.next;
            }else {
                //pre不变，删除重复节点
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
