# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        res = []
        if n < 1:
            return res
        return self.imp(1,n)
    
    def imp(self,start,end):
        if start>end:
            return [None]
        if start==end:
            return [TreeNode(start)]
        else:
            res = []
            for i in range(start,end+1):
                left_list = self.imp(start,i-1)
                right_list = self.imp(i+1,end)
                for l in left_list:
                    for r in right_list:
                        root = TreeNode(i)
                        root.left = l
                        root.right = r
                        res.append(root)
            return res
