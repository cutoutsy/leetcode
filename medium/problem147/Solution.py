# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        start = head.next
        cur = head
        pre = ListNode(-1)
        pre.next = cur
        cur.next = None
        sorted_head = pre
        while start:
            print(start.val)
            while cur:
                if start.val < cur.val:
                    temp = start
                    start = start.next
                    pre.next = temp
                    temp.next = cur
                    break
                pre = cur
                cur = cur.next
            if not cur:
                temp = start
                start = start.next
                pre.next = temp
                temp.next = None  
            pre = sorted_head
            cur = sorted_head.next
        
        return sorted_head.next
