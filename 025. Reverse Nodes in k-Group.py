# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        next_round = head.next.next
        new_head = head.next
        new_head.next=head
        head.next=self.swapPairs(next_round)
        return new_head
