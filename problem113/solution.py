#!/usr/bin/python
# -*- coding: utf-8 -*-

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def pathSum(self, root, sum):
    """
    :type root: TreeNode
    :type sum: int
    :rtype: List[List[int]]
    """
    self.ans = []
    if root is None:
        return self.ans
    def dfs(root, path):
        if root.left is None and root.right is None:
            self.ans.append(path)
        if root.left:
            dfs(root.left, path.append(root.left.val))
        if root.right:
            dfs(root.right, path.append(root.right.val))
    dfs(root, [root.val])
    return ans

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
solution = Solution()
ans = solution.pathSum(root)
for i in range(len(ans)):
    print(ans[i])
