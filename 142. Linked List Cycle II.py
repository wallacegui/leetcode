# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return None
        one,two = head.next,head.next.next
        while two is not None:
            if one==two:
                a,b = one,head
                while a!=b:
                    a=a.next
                    b=b.next
                return a
            one = one.next
            two = two.next
            if two :
                two = two.next
        return None
