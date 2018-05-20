class Solution:
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        if len(A) < 3:
            return 0
        ans = 0
        diff = A[0] - A[1]
        count = 2
        for i in range(1, len(A) - 1):
            if A[i] - A[i+1] == diff:
                count += 1
            if A[i] - A[i+1] != diff:
                if count >= 3:
                    for num in range(1, count - 1):
                        ans += num
                diff = A[i] - A[i+1]
                count = 2
        if count >= 3:
            for num in range(1, count - 1):
                ans += num
        return ans