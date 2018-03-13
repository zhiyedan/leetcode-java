package sj.sort;

import resources.ListNode;

import java.awt.*;
import java.util.List;
import java.util.Stack;

/**
 * Created by steven on 18-2-25 下午7:52
 * shijia0620@126.com
 *
 * Sort a linked list using insertion sort.
 */
public class L147insertionSortList {
    //TODO 参考了答案：由于是list，不能从后往前找位置，所以只能从前往后
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        ListNode curNode = head.next;
        while (curNode != null){
            // TODO 找位置 又是一个思维惯性，这样找到之后没法插入！
           /*preNode = newNode.next;
            while (preNode != null && preNode.val <= curNode.val){
                preNode = preNode.next;
            }*/
           ListNode walkNode = newNode;
           while (walkNode.next!=null && walkNode.next.val<curNode.val){
               walkNode = walkNode.next;
           }
//           TODO 这样自己和自己形成了回环。。。。。。
           ListNode tempNode = curNode.next;
           curNode.next = walkNode.next;
           walkNode.next = curNode;
           curNode = tempNode;
        }
        return newNode.next;
    }
//    TODO 新list是一个一个加上去的，末尾为null
    public ListNode insertionSortList2(ListNode head) {
        ListNode helper=new ListNode(0);
        ListNode pre=helper;
        ListNode current=head;
        while(current!=null) {
            pre=helper;
            while(pre.next!=null&&pre.next.val<current.val) {
                pre=pre.next;
            }
            ListNode next=current.next;
            current.next=pre.next;
            pre.next=current;
            current=next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.genList();
        L147insertionSortList a = new L147insertionSortList();
        a.insertionSortList2(list);
    }
}
