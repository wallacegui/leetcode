import sys

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = -sys.maxint-1
        current = 0
        for n in nums:
            current += n
            res = max(res,current)
            if current<0:
                current = 0
        return res
