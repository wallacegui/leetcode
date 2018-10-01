# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if intervals is None or len(intervals)<=1:
            return intervals
        sorted_itvls = sorted(intervals,key=lambda interval : interval.start)
        res = []
        pre = sorted_itvls[0]
        i = 0
        while i<len(intervals):
            interval = sorted_itvls[i]
            i += 1
            if interval.start > pre.end:
                res.append(pre)
                pre = interval
            else :
                pre.end = max(pre.end,interval.end)
        res.append(pre)
        return res
