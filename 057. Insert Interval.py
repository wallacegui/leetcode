# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        if intervals is None or len(intervals)==0:
            return [newInterval]
        s_i,e_i = self.bin_sch(intervals,newInterval.start),self.bin_sch(intervals,newInterval.end)
        print(s_i,e_i)
        pre = intervals[:s_i]
        mid = []
        start,end = newInterval.start,newInterval.end
        if start < intervals[s_i].start:
            if end < intervals[e_i].start:
                mid = [newInterval] + intervals[e_i:]
            else :
                newInterval.end = max(intervals[e_i].end,end)
                mid = [newInterval] + intervals[e_i+1:]
        
        if start >= intervals[s_i].start and start <= intervals[s_i].end:
            newInterval.start = intervals[s_i].start
            if end < intervals[e_i].start:
                mid = [newInterval] + intervals[e_i:]
            else :
                newInterval.end = max(intervals[e_i].end,end)
                mid = [newInterval] + intervals[e_i+1:]
        
        if start > intervals[s_i].end:
            pre.append(intervals[s_i])
            if end < intervals[e_i].start:
                mid = [newInterval] + intervals[e_i:]
            else :
                newInterval.end = max(intervals[e_i].end,end)
                mid = [newInterval] + intervals[e_i+1:]
        return pre+mid

    
    def bin_sch(self,intervals,target):
        start,end = 0,len(intervals)-1
        while start < end:
            mid = (start+end)/2
            if intervals[mid].start>target:
                end = mid - 1
            else :
                if intervals[mid].end<target:
                    start = mid + 1
                else: 
                    return mid
        return start        
