## Leetcode 48: Rotate Image
### 题目
给定一个n × n的二维矩阵表示一个图像。  
将图像顺时针旋转90度。  
### 例子
**例子1：** 
给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
**例子2：**
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

原地旋转输入矩阵，使其变为:  
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
### 题目假设
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。    
### 重要问题
这道题目需要注意的地方是
### 直觉
这道题目类似于矩阵操作，可以考虑矩阵相关的知识。  
### 解决方案
1. 将该矩阵进行转置，即$$A_{ij} = A_{ji}$$
2. 再将矩阵按中心水平对称置换
### 数据结构
二维数组  
### 复杂度
如果输入矩阵为n x n,  
对于转置操作时间复杂度为$$\frac{1}{2}n^2$$。
对于水平置换操作也为$$\frac{1}{2}n^2$$。
所以整体的复杂度为$$n^2$$
### 其他解法
1. 可以先进行垂直的关于中心对称置换，再进行转置。  
2. 可以采用旋转的办法，即从外到内，将每层的数字进行旋转，最后得到结果。  
### 解法比较
解法1和我的方案是差不多的。
对于解法2，代码实现比较复杂，不够简洁。
### 代码
```python
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
        
```