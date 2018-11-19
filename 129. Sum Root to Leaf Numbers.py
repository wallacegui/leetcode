# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.imp(0,root)
    
    def imp(self,pre,root):
        if root is None:
            return pre
        new_pre = pre*10+root.val
        left = self.imp(new_pre,root.left) if root.left else 0
        right = self.imp(new_pre,root.right) if root.right else 0
        return max(left + right,new_pre)
