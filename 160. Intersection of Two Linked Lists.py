# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None
        if headA==headB:
            return headA
        len_A,hA,len_B,hB = 0,headA,0,headB
                
        while hA:
            len_A +=1
            hA =hA.next
        
        while hB:
            len_B += 1
            hB = hB.next
    
        hA,hB=headA,headB
    
        while len_A>len_B and hA:
            len_A -= 1
            hA = hA.next
        
        while len_A<len_B and hB:
            len_B -= 1
            hB = hB.next
            
        while hA and hB and hA!=hB:
            # print(hA.val,hB.val)
            hA=hA.next
            hB=hB.next

        return hA
        
