class Solution:
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = []
        for i in range(len(nums)):
            index = abs(nums[i])
            nums[index - 1] = -nums[index - 1]
            if nums[index - 1] > 0: ans.append(abs(nums[i]))
        return ans