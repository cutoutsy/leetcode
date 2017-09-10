class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = head.next;
        ListNode n = reverseList(p);

        head.next = null;
        p.next = head;
        return n;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        ListNode nxt;
        while (p != null) {
            nxt = p.next;
            p.next = pre;
            pre = p;
            p = nxt;
        }
        return pre;
    }
}
