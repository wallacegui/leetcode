# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head is None or k <=0 :
            return head
        new_h = head
        n = 0
        tail = new_h
        while new_h is not None:
            tail = new_h
            new_h = new_h.next
            n += 1
        k = k%n
        if k == 0  or n==1:
            return head
        new_h,pre = head,head
        for i in range(0,k):
            new_h = new_h.next
        while new_h != tail:
            pre = pre.next
            new_h = new_h.next
        new_h = pre.next
        pre.next = None
        tail.next = head
        return new_h
        
        
