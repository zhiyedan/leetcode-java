package sj.linkedList;

import common.ListNode;

/**
 * Created by steven on 18-3-23 下午8:04
 * shijia0620@126.com
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class N_MergeList {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
                cur.next = null;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
                cur.next = null;
            }
        }
        while (list1 != null) {
            cur.next = list1;
            cur = cur.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        }
        return head.next;
    }

    // todo 递归版
    public static ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list1.next = Merge2(list1.next, list2);
                return list1;
            } else {
                list2.next = Merge2(list1, list2.next);
                return list2;
            }
        }
        return list1 == null ? list2 : list1;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(7);
        ListNode.showList(head1);
        ListNode.showList(head2);
        ListNode result = mergeNormal(head1, head2);
        ListNode.showList(result);
    }

    public static ListNode mergeNormal(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }

        return head.next;
    }

}
