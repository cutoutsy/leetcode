## 767: Reorganize String
**难度：Medium**
### 题目描述
给定一个字符串S，判断它是否可以重组为所有相邻的两个字符都不相同。  
如果可以，给出一种可能的组合结果，如果不行，返回空字符串。  
**例子1**  
输入: S = "aab"  
输出: "aba"  

**例子2**  
输入: S = "aaab"  
输出: ""  

**注意**
字符串S由小写字母组成，且长度范围在[1, 500]。  

### 解题思路
这个题目是上周末Leetcode周末比赛的第二题。  
首先我们来判断什么时候是不可能重组成功的情况，如果字符串S中的某个字符的数目超过S长度的一半，那么就不可能存在所有相邻字符不相同的情况，返回空字符串。  
其次我们需要统计S中各个字符串的数量，然后按数量从大到小进行排序，每次使用数量最大的字符串来重组且该字符与重组后的字符串的最后一个不同，如果相同，则使用数量第二大的字符串进行重组。  
我们可以使用优先队列这种数据结构来实现上面的思路。  
Java代码如下：
```java
public String reorganizeString(String S) {
    char[] alphabet = new char[26];
    for (char c : S.toCharArray()) {
        alphabet[c - 'a']++;
        if (alphabet[c - 'a'] > (S.length() + 1) / 2) {
            return "";
        }
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (int i = 0; i < alphabet.length; i++) {
        if (alphabet[i] > 0) {
            pq.add(new int[] {i + 97, alphabet[i]});
        }
    }

    StringBuffer ans = new StringBuffer();
    while (!pq.isEmpty()) {
        int[] first = pq.poll();
        if (ans.length() == 0 || first[0] != ans.charAt(ans.length() -1)) {
            ans.append((char) first[0]);
            if (--first[1] > 0) {
                pq.add(first);
            }
        } else {
            int[] second = pq.poll();
            ans.append((char) second[0]);
            if (--second[1] > 0) {
                pq.add(second);
            }
            pq.add(first);
        }
    }
    return ans.toString();
}
```
上述这种使用优先队列的方式应该是比较容易想到的方法，我自己实现的也是这样的。  
在题目讨论去还存在一种不使用优先队列的方法。思路如下：首先找出字符数量最大的字符，如果大于S长度的一半，返回空字符串，如果小于，则将该字符从索引0开始，间隔着放置(0, 2, 4...)。然后再放其他字符，  
如果偶数索引没有放完，则接着间隔着放，如果结束了，这从索引1开始(1, 3, 5...)。
具体代码如下：
```java
public String reorganizeString(String S) {
    char ch[] = new char[26];
    int max = 0;
    for(char c: S.toCharArray()) {
        ch[c - 'a'] ++;
        if(ch[c-'a'] > ch[max]) max = c - 'a';
    }
    int len = S.length();
    if(len < 2 * ch[max] - 1) return "";
    int index = 0;
    char []res = new char[len];
    for(int i = 0 ; i < ch[max]; i++) {
        res[index] = (char)(max + 'a');
        index += 2;
    }
    ch[max] = 0;
    for(int i = 0 ; i < 26; i++) {
        int count = ch[i];
        while(count > 0 ) {
            if(index >= len ) index = 1;
            res[index] = (char)(i + 'a');
            index += 2;
            count --;
        }
    }

    return new String(res);
}
```
上面代码从整理于题目讨论区。

### 总结一下
这个题目首先要判断出不能重组的条件，做之前没有想到这点，所以做的思路不是很清晰。  
优先队列这种方式应该是比较容易就能想到，其他思路可能需要对这个题目有更深的理解。优先队列这种数据结构是很好用的，在做题中好好使用吧。  

欢迎大家交流，记得点赞~~




