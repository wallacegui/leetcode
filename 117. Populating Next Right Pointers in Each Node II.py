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
        head,pre,next_level_head=root,None,None
        while head:
            pre,next_level_head = None,None
            this_level = head
            while this_level:
                if this_level.left:
                    if not pre:
                        pre = this_level.left
                        next_level_head = this_level.left
                    else:
                        pre.next = this_level.left
                        pre = pre.next
                if this_level.right:
                    if not pre:
                        pre = this_level.right
                        next_level_head = this_level.right
                    else:
                        pre.next = this_level.right
                        pre = pre.next
                this_level = this_level.next
            head = next_level_head
                
