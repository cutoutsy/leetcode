#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
	num1 = 0
	num2 = 0
	for i in range(len(moves)):
	    if moves[i] == 'L': num1 += 1
	    if moves[i] == 'R': num1 -= 1
	    if moves[i] == 'U': num2 += 1
	    if moves[i] == 'D': num2 -= 1
	return num1 == 0 and num2 == 0 

solution = Solution()
print(solution.judgeCircle("UD"))
print(solution.judgeCircle("LL"))
print(solution.judgeCircle("LDRRLRUULR"))
