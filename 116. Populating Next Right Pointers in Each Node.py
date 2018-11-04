# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if root is None:
            return
        self.connect(root.left)
        self.connect(root.right)
        self.connect_imp(root.left,root.right)
    
    def connect_imp(self,left,right):
        if left is None or right is None:
            return
        left.next = right
        self.connect_imp(left.right,right.left)
