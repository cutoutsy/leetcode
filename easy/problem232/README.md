## 232: Implement Queue using Stacks
**Easy**
### 题目描述
用栈实现队列的如下操作:  
> * push(x) -- 将元素x加入到队列末端
> * pop() -- 移除队列首元素并返回值
> * peek() -- 返回队列首元素值
> * empty() -- 返回队列是否为空

**注意**  
> * 你必须仅能使用栈的标准操作 -- push to top, peek/pop from top, size, and isempty。
> * 根据你的语言，可能你的语言不支持栈，但是你可以用用列表或者双端队列来模拟，只要你只使用栈的标准操作。
> * 你可以假设这些操作都是有效的（比如，没有pop或peek在空队列上调用）。

### 解题思路
这个题目就是利用栈来实现队列。栈是先进后出的，而队列是先进先出的，所以显然使用一个栈是不能达到要求的。  
我们可以考虑利用两个栈来实现，因为将一个栈s1的元素压到另一个栈s2，那么s2的出栈顺序就和符合队列的先进先出了。  
这个题目关键在于当pop和peek操作时，如果栈s2不为空，则直接操作栈s2，反之则需要先把s1中的所有元素弹出到栈s2中，再进行操作。至于为什么要这么做，大家可以自己想一想。  
参考代码如下：  
```java
public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int val = peek();
        s2.pop();
        return val;
    }

    /** Get the front element. */
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.size() + s2.size() == 0;
    }
}
```

### 总结一下
这个题目比较简单，就是用一种数据结构去实现另外的数据结构，考察对数据结构的理解。其他还有比如用数组或链表来实现栈和队列。  
可以对这类型的题目做个综合练习。因为这类题目在面试中还是经常遇到的。  

欢迎大家交流，记得点赞~~
