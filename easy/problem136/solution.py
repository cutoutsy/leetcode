#!/usr/bin/python
# coding: utf-8 -*-
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 0
        for x in nums:
            ans = ans^x
        return ans
nums = [1, 1, 2, 2, 3]
solution = Solution()
print(solution.singleNumber(nums))
