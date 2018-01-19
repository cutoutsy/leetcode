#!/usr/bin/python
# -*- coding: utf-8 -*-
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
	if not l1 and not l2:
	    return None
	ans = ListNode(0)
	temp = ans
	while l1 and l2:
	    if(l1.val >= l2.val):
		temp.next = l2
		l2 = l2.next
	    else:
		temp.next = l1
		l1 = l1.next
	    temp = temp.next
	if not l2:
	    temp.next = l1
	else:
	    temp.next = l2
	return ans.next
