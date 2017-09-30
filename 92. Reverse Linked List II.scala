/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
  override def toString = x + "-->" + next;
 }
 
 
    def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
        if(head == null) return head;
        var newHead = new ListNode();
        newHead.next = head;
        var preReverse = newHead;
        for(i<-2 to m){
            preReverse = preReverse.next;
        }
        val nTh = preReverse.next;
        var left = preReverse.next;
        preReverse.next = null;
        for(i<- m to n){
            val current = left;
            left = left.next;
            current.next = preReverse.next;
            preReverse.next = current;
        }
        nTh.next = left;
        return newHead.next;
    }


val n1 = new ListNode(1)
val n2 = new ListNode(2)
val n3 = new ListNode(3)
val n4 = new ListNode(4)
val n5 = new ListNode(5)
n1.next = n2;
n2.next = n3;
n3.next = n4;
n4.next = n5;

reverseBetween(n1,2,4)
