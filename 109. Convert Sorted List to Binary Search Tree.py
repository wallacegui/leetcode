# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def len_listnode(self,head):
        current = head
        res = 0
        while current is not None:
            res += 1
            current=current.next
        return res
    
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if head is None:
            return None
        n = self.len_listnode(head)
        if n == 1 :
            return TreeNode(head.val)
        tail = head
        for i in range(1,n/2):
            tail = tail.next
        mid = tail.next
        root = TreeNode(mid.val)
        tail.next = None
        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(mid.next)
        return root        
