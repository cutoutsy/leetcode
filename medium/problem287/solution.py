#!/usr/bin/python
# -*- cding: utf-8 -*-
class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None: return None
        encounter = self.findEncounter(nums)
        head = 0
        while True:
            if head == encounter: return head
            head = nums[head]
            encounter = nums[encounter]
        return None
    def findEncounter(self, nums):
        fast = 0
        slow = 0
        while True:
            fast = nums[nums[fast]]
            slow = nums[slow]
            if fast == slow:
                return slow
        return None
nums = [1, 2, 3, 4, 5, 3]
solution = Solution()
print(solution.findDuplicate(nums))
