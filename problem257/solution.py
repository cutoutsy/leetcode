#!/usr/bin/python
# -*- coding: utf-8 -*-
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
	self.ans = []
	if root is None:
	    return self.ans
	def dfs(root, path):
	    if root.left is None and root.right is None:
		self.ans += path,
	     if root.left:
		dfs(root.left, path + "->" + str(root.left.val))
	     if root.right:
		dfs(root.right, path + "->" + str(root.right.val))
	dfs(root, str(root.val))
	return self.ans
