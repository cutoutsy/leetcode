#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        ans = []
        if numRows == 0: return ans
        ans.append([1])
        for i in range(1,numRows):
            row = []
            for j in range(i+1):
                if j == 0 or j == i:
                    row.append(1)
                else:
                    row.append(ans[i-1][j-1] + ans[i-1][j])
            ans.append(row)
        return ans
