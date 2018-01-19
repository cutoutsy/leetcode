#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
	ans = None
	sums = 0
	for i in range(len(nums)):
	    sums += nums[i]
	    if i >= k: sums -= nums[i-k]
	    if i >= k-1: ans = max(ans, 1.0*sums/k)
	return ans
