#!/usr/bin/python
# -*- coding: utf-8 -*-
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        pPath = self.findPath(root, p.val)
        qPath = self.findPath(root, q.val)
        for i in range(len(pPath)-1):
            if i+1==len(qPath) or pPath[i+1].val != qPath[i+1].val:
                return pPath[i]
        return pPath[len(pPath)-1]

    def findPath(self, root, k):
        res = []
        res.append(root)
        while root:
            if root.val == k:
                break
            elif root.val > k and root.left:
                root = root.left
            elif root.val < k and root.right:
                root = root.right
            res.append(root)
        return res

solution = Solution()
root = TreeNode(6)
root.left = TreeNode(2)
root.right = TreeNode(8)
root.left.right = TreeNode(4)
print(solution.lowestCommonAncestor(root,root,root.right).val)
print(solution.lowestCommonAncestor(root,root.left,root.left.right).val)	
		
