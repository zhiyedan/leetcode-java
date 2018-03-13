package sj.sort;

import resources.ListNode;

/**
 * Created by steven on 18-2-26 下午11:46
 * shijia0620@126.com
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class L148sortList {
    public ListNode sortList1(ListNode head) {
        if(head == null) return null;
        return partation1(head,null);
    }

    //失败！！！
    public ListNode partation1(ListNode head, ListNode tail){
        //TODO 结束条件很关键！！！
        if(head == tail) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=tail && fast.next != tail){
            slow =slow.next;
            fast = fast.next.next;
        }
        partation1(head,slow);
        partation1(slow.next,tail);
        return merge(head,slow.next);
    }

    //TODO answer
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast.next = fast.next.next;
        }
        //TODO point !!! 需要实际的断开列表。
        ListNode next = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(next);
        return merge(left,right);
    }


    public ListNode merge(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        if(left.val <= right.val){
            left.next = merge(left.next,right);
            return left;
        }else {
            right.next = merge(left,right.next);
            return right;
        }
    }

    public static void main(String[] args) {
        L148sortList a = new L148sortList();
        ListNode head = ListNode.genList();
        a.sortList(head);
        ListNode.showList(head);
    }
}
