#!/usr/bin/python
# -*- coding: utf8 -*-
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
	self.total = 0
	def traverse(root):
		if not root: return
		traverse(root.right)
		root.val += self.total
		self.total = root.val
		traverse(root.left)
	traverse(root)
	return root	

root = TreeNode(5)
root.left = TreeNode(2)
root.right = TreeNode(13)
solution = Solution()
ans = solution.convertBST(root)
print(ans.val, ans.left.val, ans.right.val)
