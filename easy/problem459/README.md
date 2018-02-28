## 459: Repeated Substring Pattern
**Easy**
### 题目描述
给定一个非空的字符串，判断它是否可以由它的子字符串重复多次得到。假设给定字符串只包含小写英文字母且长度不会超过10000。   
**例子1：**  
输入: "abab"  
输出: True  
解释: 可由字符串"ab"重复两次得到  
**例子2：**  
输入: "aba"  
输出: False   
**例子3：**  
输入: "abcabcabcabc"  
输出: True  
解释: 可由字符串"abc"重复4次得到 (或者由字符串"abcabc"重复两次得到)。  
### 解题思路
由于给定字符串是有它的子字符串重复多次得到，那么子字符串的长度必然能够被字符串长度整除。假设字符串长度为n，那么满足要求的子字符串长度为n的约数（不包括n本身）。  
遍历所有n的约数，然后依次与原字符串进行比较。
我的做法是假设约数为m，那么可以每次比较原字符串的m个字符，看是否一致，如果都一致，则返回True，循环结束。
具体代码如下：
```java
public boolean repeatedSubstringPattern(String s) {
    char[] charS = s.toCharArray();
    int n = charS.length;
    for (int i = n / 2; i >= 1; i--) {
        if (n % i == 0) {
            boolean temp = false;
            for (int j = i; j < charS.length; j = j + i) {
                for (int k = j; k < j + i; k++) {
                    if (charS[k] != charS[k - i]) {
                        temp = true;
                        break;
                    }
                }
                if (temp) {
                    break;
                }
            }
            if (!temp) {
                return true;
            }
        }
    }
    return false;
}
```
在讨论区看到另一种判断思路，就是得到重复次数n/m，然后依次重复，在与原字符串比较。这种代码实现比较简单。  
具体代码如下：  
```java
public boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    for (int i = n / 2; i >= 1; i--) {
        if (n % i == 0) {
            int k = n / i;
            String sub = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            int j;
            for (j = 1; j < k; j++) {
                if (!sub.equals(s.substring(j * i, i + j * i))) {
                    break;
                }
            }
            if (j == k) {
                return true;
            }
        }
    }
    return false;
}
```

### 总结一下
这个题目思路还是很清晰的，子字符串长度是字符串长度的约数，然后再判断就好了。  
这个题目还可以用KMP来做，达到O(n)的复杂度。  

欢迎大家交流，记得点赞~~




