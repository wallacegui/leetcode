# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if len(preorder)==0 or (len(preorder)!=len(inorder)):
            return None
        root_value = preorder[0]
        root = TreeNode(root_value)
        i = inorder.index(root_value)
        left_preorder = preorder[1:1+i]
        left_inorder = inorder[0:i]
        root.left = self.buildTree(left_preorder,left_inorder)
        
        right_preorder = preorder[1+i:]
        right_inorder = inorder[1+i:]
        root.right = self.buildTree(right_preorder,right_inorder)
        return root
        
