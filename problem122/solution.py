#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
	ans = 0
	for i in range(len(prices)-1):
	    if prices[i+1] > price[i]:
		ans += prices[i+1]-prices[i]
	return ans
