#!/usr/bin/python
# -*- coding: utf-8 -*-

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None: return False
        last = head
        while head.next is not None and head.next.next is not None:
            head = head.next.next
            last = last.next
            if head == last:
                return True
        return False
