# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        odd = head
        even_head = head.next
        even = head.next
        cur = head.next
        index = 2
        while cur.next is not None:
            index += 1
            if index % 2 == 1:
                odd.next = cur.next
                odd = odd.next
            else:
                even.next = cur.next
                even = even.next
            cur = cur.next
        even.next = None
        odd.next = even_head
        
        return head
            
        