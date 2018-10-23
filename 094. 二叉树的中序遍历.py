# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        stack,res = [],[]
        while root is not None:
            stack.append(root)
            root = root.left
        while len(stack)>0:
            curt = stack.pop()
            res.append(curt.val)
            right = curt.right
            while right is not None:
                stack.append(right)
                right = right.left
        return res
