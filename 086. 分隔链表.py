# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    
    def partition(self, head, x):
        
        if head is None or head.next is None:
            return head
        fst_head = ListNode(1)
        fst_tail = fst_head
        
        snd_head = ListNode(1)
        snd_tail = snd_head
        
        current = head
        while current is not None:
            temp = current.next
            if current.val < x:
                fst_tail.next = current
                fst_tail = fst_tail.next
                fst_tail.next = None
            else :
               snd_tail.next = current
               snd_tail = snd_tail.next
               snd_tail.next = None
                
            current = temp
            
        fst_tail.next = snd_head
        
        fst_tail.next = fst_tail.next.next
        return fst_head.next
