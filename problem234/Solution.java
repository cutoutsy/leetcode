/**
 * leetcode problem 234
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        boolean res = true;
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        ListNode n3 = null;
        // 右半区反转
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n2 = head;
        // 检查回文
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return res;
    }
}
