#!/usr/bin/python
# -*- coding: utf-8 -*-
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
	last = None
	while node.next is not None:
	    node.val = node.next.val
	    last = node
	    node = node.next
	last.next = None

solution = Solution()
head = ListNode(0)
head.next = ListNode(1)
solution.deleteNode(head)
print(str(head.val))
print(type(head.next))
        
