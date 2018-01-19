#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
	if not nums:
	    return 0
       	dp = []
	if len(nums) <= 2:
	    return max(nums) 
	dp.append(nums[0])
	dp.append(nums[1])
	dp.append(nums[0] + nums[2])
	for index in range(3,len(nums)):
	    dp.append(max(dp[index-2], dp[index-3]) + nums[index])
	return max(dp)

nums1 = [1,2,1,1]
nums2 = [3,4,5,6,7]
solution = Solution()
print(solution.rob(nums1))
print(solution.rob(nums2))
