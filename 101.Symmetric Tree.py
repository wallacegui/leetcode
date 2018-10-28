# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None :
            return True
        return self.isSymmetric_imp(root.left,root.right)
    
    def isSymmetric_imp(self, left,right):
        if left is None and right is None:
            return True
        if left is None or right is None:
            return False
        if left.val != right.val:
            return False
        return self.isSymmetric_imp(left.left,right.right) and self.isSymmetric_imp(left.right,right.left)
