#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
	return list(set(nums1)&set(nums2))

nums1 = [1,2,2,1]
nums2 = [2,2]
solution = Solution()
print(solution.intersection(nums1, nums2))
