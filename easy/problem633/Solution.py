class Solution:
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        if c < 0:
            return False
        for i in range(int(c**0.5) + 1):
            temp = (c - i*i)**0.5
            if temp % 1 == 0:
                return True
        return False