/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/


class ListNode(var _x: Int = 0) {
     var next: ListNode = null
     var x: Int = _x
     override def toString() = x+"->"+next
  }
 
object Solution {
    def mergeKLists(lists: Array[ListNode]): ListNode = {
        if(lists==null || lists.length==0) return null;
        var head = new ListNode(0);
        var tail = head;
        var run = true;
        while(run){
            var min = 0;
            for(i<- 1 to lists.length-1){
                if(lists(min) == null || (lists(i)!=null && lists(i).x < lists(min).x))
                    min = i;
            }
            if(lists(min)==null) run = false;
            else{
                tail.next = lists(min);
                lists(min) = lists(min).next;
                tail = tail.next;
            }
        }
        return head.next;
    }
}
