## 794: Valid Tic-Tac-Toe State
**难度：Medium**
### 题目描述
通过字符串数组给定一个Tic-Tac-Toe（三连棋游戏，两人轮流在九格方盘上画'X'或者'O'，谁先把三个相同记号排成横线、直线、斜线，即是胜者）状态board。  
返回True如果当且仅当这个状态是一个有效的状态。  
board是3x3数组，包含字符" ", "X", "O"。" "字符代表空的格。  
Tic-Tac-Toe规则:  
1. 玩家只能轮流在空格（" "）里面画字符。
2. 第一个玩家总是画"X"，第二个玩家总是画"O"。
3. "X"和"O"只能画在空白的格里面，不能画在已经存在"O"和"X"的格里。  
4. 三个相同记号排成横线、直线、斜线即游戏结束。
5. 如果没有空的格，游戏也结束。  
6. 游戏结束不能再移动。
  
**例子1**  
输入: board = ["O  ", "   ", "   "]   
输出: false  
解释:  
第一个玩家总是画"X"。    

**例子2**  
输入: board = ["XOX", " X ", "   "]
输出: false  
解释:  
玩家应该是轮流画"O"和"X".  

**例子3**  
输入: board = ["XXX", "   ", "OOO"]
输出: false  
 
**例子4**  
输入: board = ["XOX", "O O", "XOX"]
输出: true  

**注意**
board是大小为3的字符串数组，每个字符串长度为3。  
每个board[i][j]字符都是集合{" ", "X", "O"}中的一个字符。

### 解题思路
这个题目是这周末Leetcode周末比赛的第1题。  
这到题题目很长，往往题目长的都不是太难。  
首先我们要先熟悉下Tic-Tac-Toe三连棋游戏，就是两人轮流在九格方盘上画'X'或者'O'，谁先把三个相同记号排成横线、直线、斜线，即游戏结束。  
那么我们从游戏规则中来找到不合理的状态。  
根据规则1和2，假设X的数目为countX, O的数目为countO，那么我们可以得到countX==countO，或者countX - countO == 1。  
根据游戏结束后则不能再画O和X，那么当countX==count时，如果存在三个X排成横线、直线、斜线，那么即是不合理的，因为X先画，当三个X排成横线、直线、斜线时，  
此时游戏结束，不能再画O，所以O的数目应该比X的数目少1。  
当countX - countO == 1时，如果存在三个O排成横线、直线、斜线，那么是不合理的，应该当三个O排成横线、直线、斜线时，游戏结束，不能再画X，所以此时X的数目应该和O的数目相等。    
参考代码如下：  
```java
public boolean validTicTacToe(String[] board) {
    char[][] boardChar = new char[3][3];
    for (int i = 0; i < board.length; i++) {
        boardChar[i] = board[i].toCharArray();
    }
    int countX = 0;
    int countO = 0;
    for (int i = 0; i < boardChar.length; i++) {
        for (int j = 0; j < boardChar[i].length; j++) {
            if (boardChar[i][j] == 'X') {
                countX++;
            } else if (boardChar[i][j] == 'O') {
                countO++;
            }
        }
    }
    if (countO > countX || countX - countO > 1) {
        return false;
    }
    if (countX - countO == 1) {
        if(!helper(boardChar, 'O')) {
            return false;
        }
    } else if (countX == countO) {
        if(!helper(boardChar, 'X')) {
            return false;
        }
    }

    return true;
}

private boolean helper(char[][] boardChar, char ch) {
    for (int i = 0; i < 3; i++) {
        if (boardChar[i][0] == ch && boardChar[i][0] == boardChar[i][1] && boardChar[i][1] == boardChar[i][2]) {
            return false;
        }
        if (boardChar[0][i] == ch && boardChar[0][i] == boardChar[1][i] && boardChar[1][i] == boardChar[2][i]) {
            return false;
        }
    }
    if (boardChar[0][0] == ch && boardChar[0][0] == boardChar[1][1] && boardChar[1][1] == boardChar[2][2]) {
        return false;
    }
    if (boardChar[0][2] == ch && boardChar[0][2] == boardChar[1][1] && boardChar[1][1] == boardChar[2][0]) {
        return false;
    }
    return true;
}
```

### 总结一下
这类题目主要要从给定规则中总结出限制条件，然后实现在代码中即可。还是比较简单的。  
这个题目也可以先判断是先画X的玩家赢还是先画O的玩家赢，因为当玩家赢了之后，另一个玩家不能再继续游戏，此时再判断X数目和O数目之间的关系。  

欢迎大家交流，记得点赞~~




