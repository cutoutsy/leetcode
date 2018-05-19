class Solution:
    def optimalDivision(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        if len(nums) == 1:
            return str(nums[0])
        if len(nums) == 2:
            return str(nums[0]) + "/" + str(nums[1])
        ans = ""
        for i in range(len(nums)):
            ans = ans + str(nums[i]) + "/"
            if i == 0:
                ans += '('
        ans = ans[0:-1]
        ans += ')'
        return ans
        