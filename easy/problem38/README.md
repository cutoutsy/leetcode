## 38: Count and Say
**Easy**
### 题目描述
这个题目在Leetcode上的描述不准确，导致很多人理解题目出现问题。下面重新描述一下题目：  
首先给出前10个数字的序列：
1. 1
2. 11
3. 21
4. 1211
5. 111221 
6. 312211
7. 13112221
8. 1113213211
9. 31131211131221
10. 13211311123113112211

题意就是n=1时，输出字符串1；n=2时，数上次字符串中各个数值的个数，因为上个数字字符串中有1个1，所以输出11；  
当n=3时，由于上个字符串是11，有2个1，所以输出21；当n=4时，由于上个数字的字符串是21，有1个2和1个1，所以输出1211，依次类推......  
**例子1：**  
输入: 1  
输出: "1"  
**例子2：**  
输入: 4  
输出: "1211"  
### 解题思路
这个题目理解了题目就好做了。明显的用递归来解决。    
参考代码如下：
```java
public String countAndSay(int n) {
    if (n == 1) {
        return "1";
    }
    char[] re = countAndSay(n - 1).toCharArray();
    int count = 0;
    char cur = re[0];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < re.length; i++) {
        if (cur != re[i]) {
            sb.append(count);
            sb.append(cur);
            cur = re[i];
            count = 1;
        } else {
            count++;
        }
    }
    sb.append(count > 0 ? count + String.valueOf(cur) : "");
    return sb.toString();
}
```

### 总结一下
Leetcode上的题目描述我看了好一会儿都没有看懂，后面查了一下，理解了题意，很快就做出来了。  
所以理解清楚题目的描述很重要，同时也要学会从题目描述挖掘出信息。  

欢迎大家交流，记得点赞~~




