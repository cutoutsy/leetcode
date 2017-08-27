#!/usr/bin/python
# -*- coding: utf-8 -*-
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None: return None
        encounter =  self.findEncounter(head)
        if encounter is not None:
            while True:
                if head == encounter:   return head
                head = head.next
                encounter = encounter.next
        return None
    def findEncounter(self, head):
        last = head
        while head.next is not None and head.next.next is not None:
            head = head.next.next
            last = last.next
            if head == last:
                return last
        return None
solution = Solution()
head = ListNode(3)
head.next = ListNode(2)
head.next.next = ListNode(0)
head.next.next.next = ListNode(-4)
head.next.next.next.next = head.next
print(solution.detectCycle(head).val)
