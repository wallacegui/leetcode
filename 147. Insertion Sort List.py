# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        new_head = ListNode(0)
        while head:
            first = new_head
            while first.next and first.next.val<head.val:
                first = first.next
            temp = head.next
            position = first.next
            first.next = head
            head.next = position
            head = temp
        return new_head.next
