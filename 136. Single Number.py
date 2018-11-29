class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums)==0:
            return 0;
        res = nums[0]
        for i in range(1,len(nums)):
            res ^= nums[i]
        return res
