#!/usr/bin/python
# -*- coding: utf-8 -*-
import ctypes
class Solution(object):
    def singleNum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 0
        allBytes = [0]*32
        for num in nums:
            index = 1
            for i in range(len(allBytes)):
                if index & num != 0:
                    allBytes[i] += 1
                index = index << 1
        mark = 1
        for byte in allBytes:
            if byte != 0 and byte%3 != 0:
                ans = ans | mark
            mark = mark << 1
        return ctypes.c_int32(ans).value
nums = [-2,-2,1,1,-3,1,-3,-3,-4,-2]
solution = Solution()
print(solution.singleNum(nums))
