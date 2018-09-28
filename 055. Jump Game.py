class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if nums is None or len(nums)<=1:
            return True
        crent = 0
        while crent<= len(nums):
            if nums[crent]==0:
                return False
            if crent+nums[crent]>= len(nums)-1:
                return True
            for i in range(crent+1,crent+nums[crent]+1):
                if crent+nums[crent]<=i+nums[i]:
                    crent = i
        return True
