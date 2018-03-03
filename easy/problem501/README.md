## 501: Find Mode in Binary Search Tree
**Easy**
### 题目描述
给定一个含有重复值的搜索二叉树（BST），找出所有的mode(s)（出现最频繁的元素）。  
BST定义如下：  
> * 节点左子树仅包含小于或等于该节点值的元素。
> * 节点右子树仅包含大于或等于该节点值的元素。
> * 节点的左右子树也是二叉搜索树。

**例子：**  
给定二叉树[1, null, 2, 2]  
> 1  
>  \  
>   2  
>  /  
> 2  

返回[2]。  
**注意：**
如果一个数不止一个mode，可以以任意顺序返回。  
**后续：**
是否可以不使用额外的空间（假设递归含有的栈空间不算）  
### 解题思路
假设可以使用额外空间，那么这个题目就比较简单了。  
我们可以遍历搜索二叉树，统计各个节点值出现的次数，然后再找出mode(s)即可。  
在后续中要求不使用额外的空间，但是递归栈占用的空间不算。那么我们可以使用先序遍历来做这道题目。利用变量prev表示前面的值。  
参考代码如下：
```java
Integer prev = null;
int count = 1;
int max = 0;

public int[] findMode1(TreeNode root) {
    if (root == null) {
        return new int[0];
    }
    List<Integer> list = new ArrayList<>();
    traverse(root, list);

    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
        res[i] = list.get(i);
    }
    return res;
}

private void traverse(TreeNode root, List<Integer> list) {
    if (root == null) {
        return;
    }
    traverse(root.left, list);
    if (prev != null) {
        if (root.val == prev) {
            count++;
        } else {
            count = 1;
        }
    }
    if (count > max) {
        max = count;
        list.clear();
        list.add(root.val);
    } else if (count == max) {
        list.add(root.val);
    }
    prev = root.val;
    traverse(root.right, list);
}
```

### 总结一下
对于二叉树的遍历具体执行步骤还不太熟悉，需要多熟练熟练。   

欢迎大家交流，记得点赞~~




