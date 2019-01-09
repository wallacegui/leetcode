class Solution(object):
    def maximumGap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums)<=1:
            return 0
        nums.sort()
        gap = 0
        for i in range(1,len(nums)):
            gap = max(nums[i]-nums[i-1],gap)
        return gap
        
