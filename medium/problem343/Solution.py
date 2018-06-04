class Solution:
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0] * (n + 1)
        dp[0] = 0
        dp[1] = 0
        for i in range(2, n + 1):
            for j in range(i - 1, i // 2 - 1, -1):
                k1 = dp[j]
                k2 = dp[i-j]
                if k1 < j:
                    k1 = j
                if k2 < (i-j):
                    k2 = i - j
                dp[i] = max(dp[i], k1*k2)
        return dp[n]