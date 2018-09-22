class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None:
            return 1
        i = 0 ;
        while i < len(nums):
            if nums[i] == i+1:
                i+=1
            else :
                if nums[i]>0 and nums[i]-1<len(nums) and nums[i]!=nums[nums[i]-1]://注意不和正确的交换
                    temp = nums[nums[i]-1]
                    nums[nums[i]-1] = nums[i]
                    nums[i]=temp
                else :
                    i += 1
        for i in range(0,len(nums)):
            if nums[i]!=i+1:
                return i+1
        return len(nums)+1                    
