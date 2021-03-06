# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        pre = 0
        mark,res,stack = [],[],[]
        if root:
            stack.append((1,root))
        while len(stack)>0:
            crent = stack[0]
            del stack[0]
            if crent[0]==pre:
                if pre%2==1:
                    mark.append(crent[1].val)
                else:
                    mark = [crent[1].val] + mark
            else:
                if pre>0 :
                    res.append(mark)
                mark = [crent[1].val]
                pre += 1
            if crent[1].left:
                stack.append((pre+1,crent[1].left))
            if crent[1].right:
                stack.append((pre+1,crent[1].right))
        if len(mark)>0:
            res.append(mark)
        return res
