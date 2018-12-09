# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        return self.imp(None,head,None)
        
    def imp(self,pre,head,end):
        # print('pre,head,end',self.output(pre) ,self.output(head),self.output(end))
        if not head or head.next==end:
            return head
        p = self.partition(pre,head,end)
        self.imp(p[2],p[3],end)
        return self.imp(pre,p[0],p[2]) if p[0] else p[2]
    
    def partition(self,pre,head,end):
        if not head or head.next == end:
            return (None,None,None,None)
        A,B,q,C,D=None,None,head,None,None
        new_head = head.next
        q.next =None
        while new_head!=end:
            temp = new_head.next
            if new_head.val <head.val:
                if not B:
                    A,B = new_head,new_head
                    new_head.next = q
                else:
                    new_head.next = A
                    A = new_head
            else:
                if not D:
                    C,D = new_head,new_head
                    new_head.next = end
                else:
                    new_head.next = C
                    C= new_head
            new_head=temp
        if pre and A:
            pre.next = A
        if C:
            q.next = C
        else:
            q.next = end
        # if A:
        #     self.output_node(A)
        # else:
        #     self.output_node(q)
        return (A,B,q,C,D)
    
    def output(self,node):
        return str(node.val) if node else "None"
    
    def output_node(self,node):
        if not node:
            print( None)
        else:
            x,res = node,[]
            while x:
                res.append(x.val)
                x = x.next
            print( res)
                
