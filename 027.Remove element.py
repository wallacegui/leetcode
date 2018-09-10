class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        if nums is None or len(nums)==0:
            return 0;
        i=-1
        j=0
        while j<len(nums):
            if nums[j]!=val:
                i+=1
                nums[i]=nums[j]
            j+=1
        return i+1
        
