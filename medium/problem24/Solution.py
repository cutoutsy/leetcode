# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        pre = head
        cur = head.next
        ans = cur
        tail = ListNode(0)
        while pre and cur:
            next = cur.next
            cur.next = pre
            pre.next = next
            tail.next = cur
            tail = tail.next.next
            pre = next
            if pre:
                cur = pre.next
        if pre:
            tail.next = pre
            tail = tail.next
        tail.next = None
        return ans