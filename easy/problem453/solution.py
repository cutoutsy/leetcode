#!/usr/bin/pythom
# -*- coding: utf-8 -*-
class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
	return sum(nums) - min(nums)*len(nums)	

nums = [1, 2, 3]
solution = Solution()
print(solution.minMoves(nums))
