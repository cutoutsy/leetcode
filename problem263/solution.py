#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
	if num <= 0: return False
	if num == 1: return True
	while num%2 == 0 or num%3 == 0 or num%5 == 0:
	    if num%2 == 0:
	        num /= 2
	    elif num%3 == 0:
	        num /= 3
	    else:
	        num /= 5
	
	return True if num == 1 else False

solution = Solution()
print(solution.isUgly(6))
print(solution.isUgly(8))
print(solution.isUgly(14))
