/*
Merge two sorted linked lists and return it as a new list. The new list should be made by 
splicing together the nodes of the first two lists.
*/


class ListNode(var _x: Int = 0) {
   var next: ListNode = null
   var x: Int = _x
}
 
object Solution {
    def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
        var l11=l1;
        var l22=l2;
        var head = new ListNode(0);
        var current = head;
        while(l11!=null && l22!=null){
            (l11,l22) match {
                case (null,_) =>  {
                    current.next = l22; return head.next;
                    }
                case (_,null) => {
                     current.next = l11; return head.next;
                    }
                case (x,y) if(x.x<y.x) => {
                    current.next=l11;
                    current = l11;
                    l11=l11.next;
                    }
                case _ => {
                    current.next=l22;
                    current = l22;
                    l22=l22.next;  
                    }
            }
        }
        return head.next;
    }
}
