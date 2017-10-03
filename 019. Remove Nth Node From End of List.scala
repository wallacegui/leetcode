/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        if(n<=0) return null;
        var first = head;
        var second = head;
        var i = 1;
        while(i<=n && first.next!=null){ i+=1;first=first.next;}
        while(first.next!=null) {first=first.next;second=second.next;}
        if(i==n+1 && second.next!=null) second.next=second.next.next;
        if(i==n) return head.next; 
        return head;
    }
}
