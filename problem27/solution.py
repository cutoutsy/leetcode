#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
	while val in nums:
	    nums.remove(val)
	return len(nums)	
solution = Solution()
nums = [3,2,2,3]
val = 3
print(solution.removeElement(nums,val))
