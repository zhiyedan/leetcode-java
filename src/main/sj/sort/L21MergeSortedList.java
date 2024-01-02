package sj.sort;

import common.ListNode;

/**
 * Created by steven on 18-2-25 下午4:26
 * shijia0620@126.com
 * <p>
 * Merge two sorted linked lists and return it as a new list
 */
public class L21MergeSortedList {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
//      TODO tips:new一个node，然后链接后面list
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curNode.next = l1;
                curNode = curNode.next;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                curNode = curNode.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) curNode.next = l1;
        if (l2 != null) curNode.next = l2;

        return head.next;
    }

    //    TODO 递归的方法去做会更加简单
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
