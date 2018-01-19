#!/usr/bin/python
# -*- coding: utf8 -*-

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
	ans = []
	que = [root]
	while que:
		ans.append(1.0*sum([n.val for n in que])/len(que))
		nque = []
		for n in que:
			if n.left: nque.append(n.left)
			if n.right: nque.append(n.right)
		que = nque
	return ans

root = TreeNode(3);
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)
solution = Solution()
print(solution.averageOfLevels(root)) 
