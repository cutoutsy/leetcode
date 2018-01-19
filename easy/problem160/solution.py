#!/usr/bin/python
# -*- coding: utf-8 -*-
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if headA is None or headB is None: return None
        ha = headA
        hb = headB
        longList = headA
        shortList = headB
        diff = 0
        while ha is not None or hb is not None:
            ha = ha.next
            hb = hb.next
            if ha is  None and hb is not None:
                diff += 1
                longList = headB
                shortList = headA
            if hb is None and ha is not None:
                diff += 1
                longList = headA
                shortList = headB
        while longList is not None and shortList is not None:
            if longList == shortList:
                return longList
            if diff > 0:
                diff -= 1
                longList = longList.next
            else:
                longList = longList.next
                shortList = shortList.next
        return None
