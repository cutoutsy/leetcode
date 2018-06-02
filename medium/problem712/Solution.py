class Solution:
    def minimumDeleteSum(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: int
        """
        w1 = len(s1)
        w2 = len(s2)
        dp = [[0 for j in range(w2 + 1)] for i in range(w1 + 1)]
        dp[0][0] = 0
        for i in range(1, w2 + 1):
            dp[0][i] = dp[0][i-1] + ord(s2[i-1])
        for j in range(1, w1 + 1):
            dp[j][0] = dp[j-1][0] + ord(s1[j-1])
        for i in range(1, w1 + 1):
            for j in range(1, w2 + 1):
                if s1[i-1] == s2[j-1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(ord(s1[i-1]) + ord(s2[j-1]) + dp[i-1][j-1], ord(s1[i-1]) + dp[i-1][j], ord(s2[j-1])+dp[i][j-1])
        return dp[w1][w2]
        