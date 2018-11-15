# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None :
            return 0
        mark = [-sys.maxint-1]
        res = self.max_single(root,mark)
        return max(res,mark[0])
    
    def max_single(self,root,mark):
        if root is None:
            return 0
        else:
            mark_left=[-sys.maxint-1]
            left = self.max_single(root.left,mark_left)
            mark_right=[-sys.maxint-1]
            right = self.max_single(root.right,mark_right)
            mark[0] = max(root.val,left+right+root.val,mark_left[0],mark_right[0])
            if left:
                mark[0] = max(mark[0],left)
            if right:
                mark[0] = max(mark[0],right)
            return root.val+max(left,right,0)
