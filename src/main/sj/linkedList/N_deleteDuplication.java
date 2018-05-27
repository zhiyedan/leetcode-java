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
                //pre不变，删除重复节点 todo 只链接不移动
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    public ListNode de2(ListNode pHead){
        ListNode newNode = new ListNode(-1);
        ListNode preNode = newNode;
        ListNode curNode = pHead;
        while (curNode != null){
            boolean isDuplicated = false;
            while (curNode.next!=null && curNode.next.val == curNode.val) {
                curNode = curNode.next;
                isDuplicated = true;
            }
            preNode.next = (isDuplicated)?curNode.next:curNode;
            //todo key point：如果重复，pre是不需要移动的，否则会陷入死循环。
            preNode = (isDuplicated)?preNode:preNode.next;
            curNode = curNode.next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        N_deleteDuplication a = new N_deleteDuplication();
        ListNode head = ListNode.genList();
        ListNode.showList(head);
        ListNode result = a.de2(head);
        ListNode.showList(result);
    }
}
