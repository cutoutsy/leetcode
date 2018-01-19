#!/usr/bin/python
# -*- coding: utf-8 -*-

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """	
	size = len(nums)
	if size == 1: return nums[0]
	if size == 2: return min(nums[0], nums[1])
	mid = size / 2
	if nums[mid-1] > nums[mid]: return nums[mid]
	if nums[mid] < nums[-1]: return self.findMin(nums[:mid])
	return self.findMin(nums[mid:])

solution = Solution()
nums = [4, 5, 6, 7, 0, 1, 2]
print(solution.findMin(nums))
