package sj.linkedList;

import java.util.*;

import common.ListNode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 */
public class DetectCycleL142 {

    /**
     * 投机行为，使用了hashSet
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }

        return null;
    }

    /**
     * 环形双指针，2(x+y) = x + n(y+z) + y;  x = (n-1)(y+z) + z;
     * x = z; 相遇后，快慢指针按相同速度再次相遇即为入口。
     *
     * @param head
     * @return
     */
    public ListNode detectCycleDoublePointer(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (true) {
            if (fast == slow) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }
}
