## 769: Max Chunks To Make Sorted
**难度：Medium**
### 题目描述
给定一个排列为[0, 1, ..., arr.length-1]的数组arr, 切分这个数组为一定数量的块，对每个块单独进行排序。  
然后再连接它们，结果等于排好序的数组（递增）。  
返回我们最多可以可以切分多少块。  
**例子1**  
输入: arr = [4,3,2,1,0]  
输出: 1  
解释:  
切分为2块或者更多的块，不会返回需要的结果。  
比如，切分成[4, 3], [2, 1, 0]，结果为[3, 4, 0, 1, 2]，不是排好序的。  

**例子2**  
输入: arr = [1,0,2,3,4]
输出: 4
解释:
我们可以切分为[1, 0], [2, 3, 4]。  
然而我们也可以切分为[1, 0], [2], [3], [4]，这是最多的切分方式。  

**注意**
数组arr长度在[1, 10]。  
数组arr中的元素在[0, 1, ..., arr.length - 1]。  

### 解题思路
这个题目是上周末Leetcode周末比赛的第3题，相似题目是第4题。 
我们可以看到这个数组元素和索引是一致的，都为[0, 1, ..., arr.length - 1]。如果一个元素比它的索引值大， 那么至少要划分到这个索引为这个元素的地方，最后才可能是有序的。  
比如[3, 2, 1, 0, 4]，对于元素3来说，要想最后结果是有序的，那么至少要切分到索引为3的地方，从索引0到3之间，如果有元素大于3，那么最大索引又要向右移。  
比如[1, 2, 0, 3, 4]，在索引0时，最大切分索引为1，到1的时候，由于元素为2，此时最大切分索引为2，到索引2的时候，元素为0，小于2，且此时索引等于最大切分索引，块数加1。
具体代码如下：
```java
public int maxChunksToSorted(int[] arr) {
    int ans = 0;
    int maxRight = -1;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == i && maxRight == -1) {
            ans++;
        } else {
            maxRight = maxRight == -1 ? arr[i] : Math.max(maxRight, arr[i]);
            if (maxRight == i) {
                ans++;
                maxRight = -1;
            }
        }
    }
    return ans;
}
```
这种方法的时间复杂度为O(n)，应该是最优的了，不可能数组不遍历完，就得到结果了。  
## 768: Max Chunks To Make Sorted II
问题描述基本是一样的，只是数组元素不是唯一的，而且数组长度最大为2000，元素大小最大为10**8。  
**例子1**  
输入: arr = [5,4,3,2,1]  
输出: 1  
解释:  
切分为2块或者更多的块，不会返回需要的结果。  
比如，切分成[5, 4], [3, 2, 1]，结果为[4, 5, 1, 2, 3]，不是排好序的。  

**例子2**  
输入: arr = [2,1,3,4,4]
输出: 4
解释:
我们可以切分为[2, 1], [3, 4, 4]。  
然而我们也可以切分为[2, 1], [3], [4], [4]，这是最多的切分方式。  

**注意**
数组arr长度在[1, 2000]。  
数组arr中的元素在[0, 10**8]。 
### 解题思路
由于数组元素发生了变化，不再是[0, 1, ..., arr.length - 1]，所以我们并不知道arr中元素排好序后的索引，如果我们知道了arr中元素排好序后的索引，那么我们就可以使用题目1的方法。
这可以通过排序和Map来实现。对于相同元素，排好序后索引肯定是递增的，索引我们在Map中存储第一次出现的索引，使用完之后再递增就好了。整体代码如下： 
```java
public int maxChunksToSorted(int[] arr) {
    int[] arrCopy = Arrays.copyOf(arr, arr.length);
    Arrays.sort(arr);
    Map<Integer, Integer> numIndex = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
        if (!numIndex.containsKey(arr[i])) {
            numIndex.put(arr[i], i);
        }
    }
    int ans = 0;
    int maxRight = -1;
    for (int i = 0; i < arrCopy.length; i++) {
        if (numIndex.get(arrCopy[i]) == i && maxRight == -1) {
            ans++;
        } else {
            int tempIndex = numIndex.get(arrCopy[i]);
            maxRight = maxRight == -1 ? tempIndex : Math.max(maxRight, tempIndex);
            if (maxRight == i) {
                ans++;
                maxRight = -1;
            }
        }
        numIndex.computeIfPresent(arrCopy[i], (k, v) -> v + 1);
    }
    return ans;
}
```
上面是我解决这两个题目的方法，下面我介绍一种可以同时解决这两个题目的方法，来自于题目讨论区。
这种方法主要有两个和arr长度相同的数组，一个为maxOfLeft，maxOfLeft[i]表示i(包括i)左边的所有元素中的最大值，另一个为minOfRight，maxOfRight[i]表示i(包括i)所有右边的元素中的最小值。  
然后依次遍历，当maxOfLeft[i] <= minOfRight[i + 1]，即左边的最大值小于等于右边元素的最小值时，可以切分出一个块，单独重新排序后可以插回到最后的排序数组中，块数加1。
具体代码如下：
```java
public int maxChunksToSorted(int[] arr) {
    int n = arr.length;
    int[] maxOfLeft = new int[n];
    int[] minOfRight = new int[n];

    maxOfLeft[0] = arr[0];
    for (int i = 1; i < n; i++) {
        maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
    }

    minOfRight[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
    }

    int res = 0;
    for (int i = 0; i < n - 1; i++) {
        if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
    }

    return res + 1;
}
```
上面代码从整理于题目讨论区。这种方法时间复杂度为O(n)。

### 总结一下
这个题目主要是需要结合数组元素和索引的关系，来找出切分的索引的位置。  
当然后面这种方法，是来计算左边元素的最大值和右边元素的最小值，没有用到索引，效率更高，解决范围也更广。关于这种题目，做得多了可能思路要多些。

欢迎大家交流，记得点赞~~




