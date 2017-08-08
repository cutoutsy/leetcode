#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        index = len(digits)-1
        if digits[index] + 1 != 10:
            digits[index] += 1
            return digits
        flag = 1
        head = []
        while index >= 0:
            digits[index] += flag
            if digits[index] == 10:
                digits[index] = 0
                flag = 1
                if index == 0:
                    head.append(1)
            else:
                break
            index -= 1
        return head + digits
d1 = [9]
d2 = [4,5,9,3]
solution = Solution()
print(solution.plusOne(d1))
print(solution.plusOne(d2))
