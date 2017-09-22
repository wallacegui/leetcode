/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/ 
 
 
 class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
    override def toString = x + " --> " + next;
 }

def rotateRight(head: ListNode, k: Int): ListNode = {
    if(head==null || k<=0) return head;
    var end=head;
    var n = 1;
    while(end.next!=null){
        end = end.next;
        n +=1;
    }
    var j = n-(k%n);
    var newHead=head;
    for(i<-2 to n-k){
        newHead=newHead.next;
    }
    end.next=head;
    end = newHead;
    var result= newHead.next;
    end.next = null;
    return result;
}

def rotateRight(head: ListNode, k: Int): ListNode = {
    if(head==null || k<=0) return head;
    var end=head;
    var n = 1;
    while(end.next!=null){
        end = end.next;
        n +=1;
    }
    end.next = head;
    for(i<- 0 to n-k%n-1){
        end = end.next;
    }
    var newHead = end.next;
    end.next = null;
    return newHead;
}

val n1 = new ListNode(1)
val n2 = new ListNode(2)
val n3 = new ListNode(3)
val n4 = new ListNode(4)
n1.next=n2
n2.next=n3;
n3.next=n4;

rotateRight(n1,0)


val n1 = new ListNode(1)
val n2 = new ListNode(2)
val n3 = new ListNode(3)
val n4 = new ListNode(4)
n1.next=n2
n2.next=n3;
n3.next=n4;

rotateRight(n1,1)


val n1 = new ListNode(1)
val n2 = new ListNode(2)
val n3 = new ListNode(3)
val n4 = new ListNode(4)
n1.next=n2
n2.next=n3;
n3.next=n4;

rotateRight(n1,2)

val n1 = new ListNode(1)
val n2 = new ListNode(2)
val n3 = new ListNode(3)
val n4 = new ListNode(4)
n1.next=n2
n2.next=n3;
n3.next=n4;

rotateRight(n1,3)

val n1 = new ListNode(1)
val n2 = new ListNode(2)
val n3 = new ListNode(3)
val n4 = new ListNode(4)
val n5 = new ListNode(5)
n1.next=n2
n2.next=n3;
n3.next=n4;
n4.next=n5
