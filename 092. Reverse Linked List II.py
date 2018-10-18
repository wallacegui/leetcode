# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        newHead = ListNode(1)
        newHead.next = head
        pre = newHead
        for i in range(1,m):
            pre = pre.next
        tail = pre.next
        next = tail.next
        for i in range(m,n):
            temp = next.next
            next.next = pre.next
            pre.next = next
            next = temp
        tail.next = next
        return newHead.next
