#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
	ans = 0
	k = len(s)-1
	index = 0
	while k >= 0:
	    ans +=  (ord(s[k])-64) * pow(26, index)
	    index += 1
	    k -= 1
	return ans

solution = Solution()
print(solution.titleToNumber('BA'))
print(solution.titleToNumber('AB'))
