#!/usr/bin/python
# -*- coding: utf-8 -*-
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    ans = 0
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        Solution.ans = 0
        self.findLeftNode(root)
        return Solution.ans

    def findLeftNode(self, root):
        if not root:
            return
        if root.left:
            if not root.left.left and not root.left.right:
                Solution.ans += root.left.val
            self.findLeftNode(root.left)
        if root.right:
            self.findLeftNode(root.right)

solution = Solution()
root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7) 
root1 = TreeNode(1)
print(solution.sumOfLeftLeaves(root))
print(solution.sumOfLeftLeaves(root1))
