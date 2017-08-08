#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
	ans = [0]*(rowIndex+1)
	ans[0] = 1
	for i in range(1, rowIndex+1):
	    temp1 = 1
	    for j in range(i+1):
	        if j == 0 or j == i:
		    ans[j] = 1
		else:
		    temp2 = ans[j]
		    ans[j] += temp1
		    temp1 = temp2
		    
	return ans
solution = Solution()
print(solution.getRow(3))
print(solution.getRow(4))
