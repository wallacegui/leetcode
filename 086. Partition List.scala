/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

class ListNode(var _x: Int = 0) {
   var next: ListNode = null
   var x: Int = _x
   override def toString = x +"-->" + next
}

def partition(head: ListNode, x: Int): ListNode = {
    if(head==null || head.next==null) return head;
    var less = new ListNode();
    var lessLast = less;
    var notLess = new ListNode();
    var notLessLast = notLess;
    var node = head;
    while(node!=null){
        val temp = node.next;
        node.next = null;
        if(node.x<x){
            lessLast.next=node;
            lessLast = node;
        }else{
            notLessLast.next=node;
            notLessLast = node;
        }
        node = temp;
    }
    lessLast.next = notLess.next;
    return less.next;
}

val n1 = new ListNode(1)
val n2 = new ListNode(4)
val n3 = new ListNode(3)
val n4 = new ListNode(2)
val n5 = new ListNode(5)
val n6 = new ListNode(2)
n1.next=n2;
n2.next=n3;
n3.next=n4;
n4.next=n5;
n5.next=n6;
partition(n1,3)
