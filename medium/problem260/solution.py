#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        diff = 0
        for num in nums:
            diff ^= num
        diff &= -diff

        res = [0, 0]
        for n in nums:
            if n & diff == 0:
                res[0] ^= n
            else:
                res[1] ^= n
        return res

solution = Solution()
nums = [1, 2, 1, 3, 2, 5]
print(solution.singleNumber(nums))
