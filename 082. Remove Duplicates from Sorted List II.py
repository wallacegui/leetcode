# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None :
            return None
        
        newHead = ListNode(0)
        newHead.next = head
        current = newHead
        while current.next :
            mark = current.next.val
            if current.next.next and current.next.next.val == mark:
                while current.next and current.next.val== mark:
                    current.next = current.next.next
            else:
                current = current.next
        return newHead.next
