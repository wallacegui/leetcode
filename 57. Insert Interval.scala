/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


*/

class Interval(var _start: Int = 0, var _end: Int = 0) {
    var start: Int = _start
    var end: Int = _end
    override def toString = start + " -> " + end
  }
 
object Solution {
    def insert(intervals: List[Interval], newInterval: Interval): List[Interval] = {
        val start = newInterval.start;
        val end = newInterval.end;
        val before  = intervals.filter(_.end<start);
        val toMerge = intervals.filter( x => (x.start<=start && x.end>=start) ||
                                       (x.start>=start && x.end<=end) ||
                                       (x.start<=end && x.end >= end));
        val after = intervals.filter(_.start>end);
        if(toMerge.length>0){
            val newStart = math.min(toMerge(0).start,start);
            val newEnd = math.max(toMerge.last.end,end);
            val newInter = new Interval(newStart,newEnd);
            return before ++ List(newInter) ++ after;
        }else{
            return before ++ List(newInterval) ++ after; 
        }
    }
}

val x1=new Interval(1,3);
val x11 = new Interval(6,9);
val x2=new Interval(2,6);
val x3=new Interval(8,10);
val x4=new Interval(15,18);

val intervals = List(x1,x11)
val newInterval = new Interval(2,5)

Solution.insert(intervals,newInterval)
