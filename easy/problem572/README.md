## 572:Subtree of Another Tree
**Easy**
### 题目描述
给你两个非空的二叉树s和t, 检查二叉树t是否与s的某子树含有相同的拓扑结构和节点值。  
s的一棵子树指s中的一个节点以及这个节点的所有子节点，s也可以看做它自己的子树。  
**例子1**  
二叉树s:  
>         3  
>        /  \  
>       4    5  
>      / \  
>     1   2  

二叉树t:  
>       4   
>      / \  
>     1   2  

返回true, 因为t有和s子树相同的结构和节点值。  
**例子2**  
二叉树s:  
>       3  
>      / \  
>      4   5  
>      / \  
>     1   2  
>        /  
>       0  
二叉树t:  
>       4  
>      / \  
>     1   2  

返回false    
### 解题思路
这个题目和我之前在《程序员代码面试指南：IT名企算法与数据结构题目最优》里面看过的一道题是一样的，所以我首先介绍时间复杂度为线性的解题方法，如果二叉树s的节点数为m，二叉树t的节点数为n，则时间复杂度为O(m+n)   
第一步是将二叉树s和t进行先序遍历，这个和一般的先序遍历有点不同，如果节点有值，则字符串中加上该节点的值，如果是空，则用‘#’替代，同时每个节点值之间用'!'分隔。  
第二步则是判断二叉树s先序遍历生成的字符串中是否包含二叉树t先序遍历生成的字符串，如果包含则返回true，反之则返回false。这一步可以用Java内置的String.contains()方法，但这个方法的时间复杂度  
不是线性的，所以我们可以使用KMP算法来解决这个问题。  
使用递归的方法对二叉树进行先序遍历，Java代码如下：
```java
public String serialByPre(TreeNode head) {
    if (head == null) {
        return "#!";
    }
    String res = head.val + "!";
    res += serialByPre(head.left);
    res += serialByPre(head.right);
    return res;
}
```
关于KMP算法，这儿就不详细介绍了，只给出KMP算法的Java实现，当然为了简便，你也可以使用Java内置的String.contains()方法  
KMP Java代码如下：  
```java
public int getIndexOf(String s, String m) {
    if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
        return -1;
    }
    char[] ss = s.toCharArray();
    char[] ms = m.toCharArray();
    int si = 0;
    int mi = 0;
    int[] next = getNextArray(ms);
    while (si < ss.length && mi < ms.length) {
        if (ss[si] == ms[mi]) {
            si++;
            mi++;
        } else if (next[mi] == -1) {
            si++;
        } else {
            mi = next[mi];
        }
    }
    return mi == ms.length ? si - mi : -1;
}

// 获取Next数组
public int[] getNextArray(char[] ms) {
    if (ms.length == 1) {
        return new int[] { -1 };
    }
    int[] next = new int[ms.length];
    next[0] = -1;
    next[1] = 0;
    int pos = 2;
    int cn = 0;
    while (pos < next.length) {
        if (ms[pos - 1] == ms[cn]) {
            next[pos++] = ++cn;
        } else if(cn > 0) {
            cn = next[cn];
        } else {
            next[pos++] = 0;
        }
    }
    return next;
}
```
然后就是在判断函数中调用，代码如下：  
```java
public boolean isSubtree(TreeNode s, TreeNode t) {
    String sStr = serialByPre(s);
    String tStr = serialByPre(t);
    int index = getIndexOf(sStr, tStr);
    return index != -1 && (index == 0 || sStr.charAt(index-1) == '!');
}
```
最后在判断的时候，由于存在节点数字包含的情况，比如一个二叉树s只有一个节点12，那么生成的字符串为'12!#!#!'，二叉树t只有一个节点为2，那么生成的字符串为'2!#!#!'，可以看到  
前面的字符串是包含后面的字符串的，但是其实节点值不相等，应该返回false。所以当包含时，还要判断要么index==0，或者index的前一个字符为'!'。  
除了上面的方法，我们还可以对于二叉树的每一棵子树都去判断是否与二叉树t的拓扑结构和节点值是否完全一样，采用递归的方式。  
Java代码如下：  
```java
public boolean isSubtree(TreeNode s, TreeNode t) {
    Queue<TreeNode> nodes = new ArrayDeque<>();
    nodes.offer(s);
    while (!nodes.isEmpty()) {
        TreeNode node = nodes.poll();
        if (isSameTree(node, t)) {
            return true;
        }
        if (node.left != null) {
            nodes.offer(node.left);
        }
        if (node.right != null) {
            nodes.offer(node.right);
        }
    }
    return false;
}

public boolean isSameTree(TreeNode s, TreeNode t) {
    if(s == null || t == null) return s == t;
    if (s.val != t.val) return false;
    return isSame(s.left, t.left) && isSame(s.right, t.right);
}
```
上面代码从整理于题目讨论区。

总的来说，后面这种方法是比较容易想到的，但是较于第一种方法，复杂度很高。第一种方法里面的KMP算法的实现也是比较难的，多多练习吧。

欢迎大家交流，记得点赞~~




