# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        res = []
        self.imp(root,sum,[],res)
        return res
    
    def imp(self,root,sum,mark,res):
        if root is None :
            return
        
        if root.left is None and root.right is None:
            if sum ==root.val:
                mark.append(root.val)
                res.append(mark)
        
        if root.left:
            self.imp(root.left,sum-root.val,mark+[root.val],res)
        if root.right:
            self.imp(root.right,sum-root.val,mark+[root.val],res)
        
        
