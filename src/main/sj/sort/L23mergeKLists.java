package sj.sort;

import resources.ListNode;

/**
 * Created by steven on 18-2-25 下午6:47
 * shijia0620@126.com
 * <p>
 * 两条变为k条
 */
public class L23mergeKLists {
    //TODO 这种方法超时了。。。。
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) return null;
        ListNode list = lists[0];
        for (int i = 1; i < lists.length; i++) {
            list = recursive(list, lists[i]);
        }
        return list;
    }

    public ListNode recursive(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        if (node1.val <= node2.val) {
            node1.next = recursive(node1.next, node2);
            return node1;
        }
        node2.next = recursive(node1, node2.next);
        return node2;
    }

    //    TODO 分治的方法
    public ListNode mergeKLists2(ListNode[] lists) {
        return patation(lists, 0, lists.length - 1);
    }

    public ListNode patation(ListNode[] lists, int begin, int end) {
        if (begin > end) return null;
        if (begin == end) return lists[begin];
        int mid = (begin + end) >> 1;
        ListNode left = patation(lists, begin, mid);
        ListNode right = patation(lists, mid + 1, end);
        return recursive(left, right);
    }
}
