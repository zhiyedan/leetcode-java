package resources;

/**
 * Created by steven on 18-2-24 下午9:54
 * shijia0620@126.com
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
    public static ListNode genList(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        return node1;
    }
    public static void showList(ListNode head){
        while (head != null){
            String tail = (head.next != null)?"->":"";
            System.out.print(head.val+tail);
            head = head.next;
        }
    }
}
