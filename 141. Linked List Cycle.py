# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None or head.next is None:
            return False
        one,two = head.next,head.next.next
        while two is not None:
            if one==two:
                return True
            one = one.next
            two = two.next
            if two :
                two = two.next
        return False
