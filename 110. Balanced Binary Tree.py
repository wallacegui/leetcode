# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.imp(root)[1]
    
    def imp(self,root):
        if root is None:
            return (0,True)
        else:
            left = self.imp(root.left)
            right = self.imp(root.right)
            if left[1] and right[1] and abs(left[0]-right[0])<2:
                return (1+max(right[0],left[0]),True)
            else :
                return  (1+max(right[0],left[0]),False)
