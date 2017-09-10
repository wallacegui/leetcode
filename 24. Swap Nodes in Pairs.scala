/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

  class ListNode(var _x: Int = 0) {
     var next: ListNode = null
     var x: Int = _x
     override def toString() = x+"->"+next
  }
 

def swapPairs(head: ListNode): ListNode = {
        if(head ==null || head.next ==null) return head;
        val headForNext = swapPairs(head.next.next);
        val newHead = head.next;
        head.next = headForNext;
        newHead.next=head;
        return newHead;
}
