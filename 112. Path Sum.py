# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if not root:
            return False
        if root and not root.left and not root.right and sum==root.val :
            return True
        left,right = False,False
        if root.left:
            left = self.hasPathSum(root.left,sum-root.val)
        if root.right:
            right = self.hasPathSum(root.right,sum-root.val)
        return left or right
