# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if len(inorder)==0 or (len(inorder)!=len(postorder)):
            return None
        root_value = postorder[-1]
        root = TreeNode(root_value)
        i = inorder.index(root_value)
        
        left_inorder = inorder[0:i]
        left_postorder = postorder[0:i]

        root.left = self.buildTree(left_inorder,left_postorder)
        
        right_inorder = inorder[1+i:]
        right_postorder = postorder[i:-1]
        root.right = self.buildTree(right_inorder,right_postorder)
        return root
        
