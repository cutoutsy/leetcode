## 766: Toeplitz Matrix
**Easy**
### 题目描述
如果矩阵中每条自左上至右下的斜线上的元素相同，则称这个矩阵为Toeplitz矩阵(托普利茨矩阵)。  
现在给定一个M x N的矩阵，如果它是Toeplitz矩阵，则返回True，反之则返回False。   
**例子1**  
 输入: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]  
 输出: True  
 解释:  
 1234  
 5123  
 9512  

在上面的矩阵中，对角线为"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"，每个对角线上的元素都一样，所以返回True。  
**例子2**  
输入: matrix = [[1,2],[2,2]]  
输出: False  
解释:  
对角线"[1, 2]" 元素不相同。返回False。  

**注意**
矩阵matrix是二维的整数数组。  
矩阵matrix的行和列的数量在[1, 20]。  
矩阵中元素matrix[i][j]大小在[0, 99]。  
### 解题思路
这道题目是上周末Leetcode的比赛题的第一题，在这儿讲下我是怎么做的。  
这个题目咋一看我们若是能够按对角线遍历，然后在每个对角线比较元素是否相同就可以了。这让我想起在《程序员代码面试指南：IT名企算法与数据结构题目最优》里面看过的一道题，  
书中的题目是给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，例如：
> 1 2 3 4  
> 5 6 7 8  
> 9 10 11 12  

"之"字形打印的结果为：1,2,5,9,6,3,4,7,10,11,8,12。
我们可以看到这个题目的打印就是按照对角线的方式进行打印的，只不过这儿是从左上角开始，在我们这个题目中，如果我们从左下角开始打印，是不是这个问题就解决了呢。  
实现方法是这样处理的：
1. 上坐标(tR, tC)初始为(M - 1, 0)，先沿着矩阵的第一列移动(tR--)，当到达第一行时，再按列移动(tC++)。  
2. 下坐标(dR, dC)初始为(M - 1, 0)，先养着矩阵最后一行移动(dC++)，当到达最后一行最右边是，再向上移动(dR--)。  
3. 上坐标和下坐标同步移动，每次移动后的上坐标和下坐标的连线就是矩阵中的一条斜线，比较斜线上的元素即可。  

具体Java代码如下：
```java
public boolean isToeplitzMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int tR = m - 1;
    int tC = 0;
    int dR = m - 1;
    int dC = 0;
    while (tC != n) {
        if (!check(matrix, tR, tC, dR, dC)) {
            return false;
        }
        tC = tR == 0 ? tC + 1 : tC;
        tR = tR == 0 ? 0 : tR - 1;
        dR = dC == n -1 ? dR - 1 : dR;
        dC = dC == n - 1 ? dC : dC + 1;
    }
    return true;
}

private boolean check(int[][] matrix, int tR, int tC, int dR, int dC) {
    int num = matrix[tR][tC];
    while (tR != dR + 1) {
        if (matrix[tR++][tC++] != num){
            return false;
        }
    }
    return true;
}
```
后面在讨论区看到一种很简单的想法，在这儿和大家分享下。  
仔细观察这种矩阵，可以发现从第一行到倒数第二行，每个元素和它右下角的元素都是相等的，如果不相等，则可以返回False。这样的话这个题目就简单了，具体代码如下：  
```java
public boolean isToeplitzMatrix(int[][] matrix) {
   for (int i = 0; i < matrix.length - 1; i++) {
       for (int j = 0; j < matrix[i].length - 1; j++) {
           if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
       }
   }
   return true;
}
```
我的代码好复杂，逃~~  

### 总结一下
总的来说，这个题目不难，我们可以用这种矩阵的定义来思考，去考察每个对角线的元素是否相同，或者观察矩阵元素的规律，比如第二种方法，或者找到矩阵元素下标对应的规律也是可以的。  

欢迎大家交流，记得点赞~~




