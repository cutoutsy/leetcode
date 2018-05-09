class Solution:
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            for j in range(i + 1):
                self.swap(matrix, i, j, j, i)
        for i in range(n // 2):
            for j in range(m):
                self.swap(matrix, j, i, j, n - 1 - i)    
        
        
    def swap(self, matrix, i1, j1, i2, j2):
        temp = matrix[i1][j1]
        matrix[i1][j1] = matrix[i2][j2]
        matrix[i2][j2] = temp
        