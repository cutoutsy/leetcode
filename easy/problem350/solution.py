#!/usr/bin/python
# -*- coding: utf-8 -*-
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
	return inter(nums1, nums2) if (len(nums1)<len(nums2)) else inter(nums2,nums1)
		
def inter(shortnums1, longnums2):
    ans = []
    for n in shortnums1:
	if(n in longnums2):
	    longnums2.remove(n)
	    ans.append(n)
    return ans

nums1 = [1,2,2,1]
nums2 = [2,2]
solution = Solution()
print(solution.intersect(nums1,nums2))
