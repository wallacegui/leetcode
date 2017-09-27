/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

class ListNode(var _x: Int = 0) {
   var next: ListNode = null
   var x: Int = _x
   override def toString = x +"-->" + next
 }

def deleteDuplicates(head: ListNode): ListNode = {
    if(head==null || head.next==null ) return head;
    var newHead = new ListNode();
    newHead.next = head;
    var pre = newHead;
    var current = pre.next;
    println(current)
    while(current != null){
        var dup = false;
        while(current.next!=null && current.x==current.next.x){
            pre.next = current.next;
            current = pre.next;
            dup = true;
        }
        println(dup)
        if(dup) {
            pre.next = current.next;//不移动pre
        }else{
            pre = pre.next;//移动pre
        }
        current = pre.next;//移动current
    }
    return newHead.next;       
 }

 val n1 = new ListNode(1)
 val n2 = new ListNode(1)
 n1.next = n2;
 deleteDuplicates(n1)
