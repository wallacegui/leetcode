# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):

    stack = []
    
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.inorder(root)
        print(self.stack)

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        res = self.stack[0]
        del self.stack[0]
        return res
        

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        return len(self.stack)>0
    
    def inorder(self,root):
        if root:
            if root.left:
                self.inorder(root.left)
            self.stack.append(root.val)
            if root.right:
                self.inorder(root.right)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
