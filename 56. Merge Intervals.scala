/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/


class Interval(var _start: Int = 0, var _end: Int = 0) {
    var start: Int = _start
    var end: Int = _end
    override def toString = start + " -> " + end +";"
  }
 
object Solution {
    def merge(intervals: List[Interval]): List[Interval] = {
        val sorted = intervals.sortWith(_.start < _.start);
        mergeImp(sorted);
    }

    def mergeImp(intervals: List[Interval]):List[Interval] = {
        intervals match {
            case List() => List();
            case x::List() =>List(x);
            case x::y::list => {
                if(x.end>=y.start){
                    merge(new Interval(x.start,y.end)::list)
                }else{
                    x::merge(y::list);
                }
            }
        }
    }
}


val x1=new Interval(1,3);
val x2=new Interval(2,6);
val x3=new Interval(8,10);
val x4=new Interval(15,18);

val list = List(x1,x2,x3,x4)

Solution.merge(list)
