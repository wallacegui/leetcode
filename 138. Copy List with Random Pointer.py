# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if head is None:
            return None
        node = head
        while node:
            new_node = RandomListNode(node.label)
            new_node.next = node.next
            node.next = new_node
            node = new_node.next
        
        node = head
        while node :
            random = node.random
            if random:
                next_random = random.next
                node.next.random = next_random
            node = node.next.next
            
        new_head,node = head.next,head
        while node:
            next = node.next
            real_next = next.next
            if real_next:
                next.next = real_next.next
            else:
                next.next = None
            node.next = real_next
            node = real_next
        return new_head
        
