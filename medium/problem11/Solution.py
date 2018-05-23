class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        ans = 0
        pointer1 = 0
        pointer2 = len(height) - 1
        while pointer1 < pointer2:
            if height[pointer1] <= height[pointer2]:
                ans = max(ans, (pointer2 - pointer1)*height[pointer1])
                pointer1 += 1
            else:
                ans = max(ans, (pointer2 - pointer1)*height[pointer2])
                pointer2 -= 1
        return ans
        