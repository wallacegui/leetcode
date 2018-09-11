class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if nums is None or len(nums)<=1:
            return 
        i = len(nums) - 1
        while i >0 and nums[i-1]>=nums[i]:
            i -= 1
        j = len(nums) - 1
        if i==0 :
            while i<j:
                temp = nums[j]
                nums[j]=nums[i]
                nums[i] = temp
                i+=1
                j-=1            
            return
        while nums[j]<=nums[i-1]:
            j -= 1
        temp = nums[j]
        nums[j]=nums[i-1]
        nums[i-1] = temp
        j = len(nums)-1
        while i<j:
            temp = nums[j]
            nums[j]=nums[i]
            nums[i] = temp
            i+=1
            j-=1
        
