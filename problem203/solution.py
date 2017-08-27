#!/usr/bin/python
# -*- coding: utf-8 -*-
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        if head is None:    return head
        ans = None
        last = head
        while head is not None:
            if head.val == val:
                last.next = head.next
            else:
                last = head
                if ans is None:
                    ans = head
            head = head.next
        return ans

solution = Solution()
head = ListNode(1)
head.next = ListNode(6)
ans = solution.removeElements(head, 6)
while ans is not None:
    print(ans.val)        
    ans = ans.next
