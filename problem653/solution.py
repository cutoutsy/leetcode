#!/usr/bin/python
# -*- coding: utf-8 -*-
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
	self.dset = set()
	self.traverse(root)
    	for n in self.dset:
	    if k - n != n and k -n in self.dset:
		return True
	return False
	 
    def traverse(self, root):
	if not root: return
	self.dset.add(root.val)
	self.traverse(root.left)
	self.traverse(root.right)

solution = Solution()
root1 = TreeNode(5)
root1.left = TreeNode(3)
root1.right = TreeNode(6)
root1.left.left = TreeNode(2)
root1.left.right = TreeNode(4)
root1.right.right = TreeNode(7)

print(solution.findTarget(root1,9))
print(solution.findTarget(root1,28))
