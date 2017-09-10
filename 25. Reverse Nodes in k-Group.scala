/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseKGroup(head: ListNode, k: Int): ListNode = {
        var tail = head;
        
        for(i <- 2 to k){
            if(tail == null) return head;
            else tail = tail.next;
        }
        if(tail == null) return head;
        else{
            val headForNext = reverseKGroup(tail.next,k);
            tail.next = null;
            reverse(head);
            head.next = headForNext;
            return tail;
        }
    }

    def reverse(head:ListNode):ListNode = {
        var newHead= head;
        var tail = head.next;
        head.next = null;
        while(tail !=null){
            val next = tail.next;
            val current = tail;
            tail = next;
            current.next = newHead;
            newHead = current;
        }
        return newHead;
    }
}
