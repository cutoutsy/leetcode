class Solution:
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        n = len(matrix)
        l, r = matrix[0][0], matrix[-1][-1]
        while l <= r:
            mid = (l + r) >> 1
            high = n - 1
            count = 0
            for row in range(n):
                while high > -1 and matrix[row][high] > mid:
                    high -= 1
                count += high +1
            if count >= k:
                r = mid - 1
            else:
                l = mid + 1
        return l