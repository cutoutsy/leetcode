class Solution:
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        def count(n):
            coun = 0
            while n != 0:
                n &= (n-1)
                coun += 1
            return coun
        ans = []
        while num >= 0:
            ans.insert(0, count(num))
            num -= 1
        return ans