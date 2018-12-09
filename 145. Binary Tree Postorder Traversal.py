# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        s,pre,res = [root],None,[]
        while s:
            top = s[-1]
            if self.check(pre,top):
                pre = s.pop()
                res.append(pre.val)
            else :
                if top.right:
                    s.append(top.right)
                if top.left:
                    s.append(top.left)
        return res
    
    def check(self,pre,curr):
        return (curr.left is None and curr.right is None) or (pre and pre == curr.right) or  (curr.right is None and pre == curr.left)
