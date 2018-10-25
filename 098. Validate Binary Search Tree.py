# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None :
            return True
        return self.imp(root)[2]
    
    def imp(self,root):
        left = self.imp(root.left) if root.left else None
        right = self.imp(root.right) if root.right else None
        min,max,res = root.val,root.val,True
        if left:
            res = res and left[2] and (left[1]<root.val)
            min = left[0]
        if right :
            res = res and right[2] and (right[0]>root.val)
            max = right[1]
        
        return (min,max,res)
        
