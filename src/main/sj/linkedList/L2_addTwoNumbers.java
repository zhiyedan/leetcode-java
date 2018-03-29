package sj.linkedList;

import resources.ListNode;

/**
 * Created by steven on 18-3-28 下午7:55
 * shijia0620@126.com
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class L2_addTwoNumbers {
    public static ListNode solution(ListNode l1, ListNode l2){
        if(l1 == null || l2==null) return null;
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null || l2 != null || carry != 0){
            int sum = ((l1==null)?0:l1.val)+((l2==null)?0:l2.val)+carry;
            carry = sum/10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }
        return head;
    }
}
