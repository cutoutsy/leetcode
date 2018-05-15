# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def splitListToParts(self, root, k):
        """
        :type root: ListNode
        :type k: int
        :rtype: List[ListNode]
        """
        ans = []
        if root is None:
            ans = [None] * k
            return ans
        length = 1
        head = root
        while head.next is not None:
            length += 1
            head = head.next
        part_len = length // k
        append = length % k
        for i in range(k):
            head = ListNode(-1)
            temp = head
            for i in range(part_len):
                temp.next = root
                temp = temp.next
                root = root.next
            if append > 0:
                temp.next = root
                temp = temp.next
                root = root.next
                append -= 1
            temp.next = None
            ans.append(head.next)
        return ans
        
        