#!/usr/bin/python
# -*- coding: utf-8 -*-
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
	if not root:
	    return True
	queue = []
	queue.append(root)
	while queue:
	    nqueue = []
	    begin = 0
	    end = len(queue)-1
	    while begin <= end:
		if queue[begin] != 0 and queue[end] != 0:
		    if queue[begin].val != queue[end].val:
		        return False
		elif not (queue[begin] == 0 and  queue[end] == 0):
		    return False
		begin += 1
		end -= 1
	    for i in range(len(queue)):
		if queue[i] != 0:
		    nqueue.append(0 if not queue[i].left else queue[i].left)
		    nqueue.append(0 if not queue[i].right else queue[i].right)
	    queue = nqueue
	return True
root1 = TreeNode(1)
root1.left = TreeNode(2)
root1.right = TreeNode(2)
root1.left.left = TreeNode(3)
root1.left.right = TreeNode(4)
root1.right.left = TreeNode(4)
root1.right.right = TreeNode(3)

root2 = TreeNode(1)
root2.left = TreeNode(2)
root2.right = TreeNode(2)
root2.left.right = TreeNode(3)
root2.right.right = TreeNode(3)
solution = Solution()
print(solution.isSymmetric(root1))
print(solution.isSymmetric(root2))
