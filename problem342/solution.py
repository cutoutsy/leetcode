#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
	return num > 0 and (num & (num-1)==0 and num & 0x55555555>0



solution = Solution()
print(solution.isPowerOfFour(16))
print(solution.isPowerOfFour(5))
print(solution.isPowerOfFour(1))
print(solution.isPowerOfFour(0))
print(solution.isPowerOfFour(2))
