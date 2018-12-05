# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return 
        l0=head.next
        n= 0
        while l0 is not None:
            n +=1
            l0 = l0.next
        last = head.next
        for i in range(0,(n-1)/2):
            last = last.next
        # print(last.val)
        ln = self.reverse(last.next)
        last.next = None
        l0=head
        while ln and l0:
            new_l0 = l0.next
            new_ln = ln.next
            l0.next = ln
            ln.next = new_l0
            l0=new_l0
            ln=new_ln
        
        
    def reverse(self,head):
        if head is None or head.next is None:
            return head
        res = ListNode(0)
        while head :
            new_head = head.next
            head.next = res.next
            res.next = head
            head = new_head
        return res.next
            
