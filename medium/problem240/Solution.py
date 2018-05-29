class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m = len(matrix)
        if m == 0:
            return False
        
        n = len(matrix[0])
        if n == 0:
            return False
        
        for i in range(m):
            if matrix[i][0] > target:
                return False
            if matrix[i][n-1] < target:
                continue
            if target in matrix[i]:
                return True
        return False