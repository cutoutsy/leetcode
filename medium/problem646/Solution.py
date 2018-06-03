class Solution:
    def findLongestChain(self, pairs):
        """
        :type pairs: List[List[int]]
        :rtype: int
        """
        pairs.sort(key=lambda x: x[1])
        current, ans = float('-inf'), 0
        for x,y in pairs:
            if current < x:
                current = y
                ans += 1
        return ans