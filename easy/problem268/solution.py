#!/usr/bin/python
# -*- coding: utf-8 -*-

class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None: return None
        sum = (1+len(nums))*len(nums)/2
        for x in nums:
            sum -= x
        return sum
