class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if nums is None or len(nums)<=1:
            return
        zero,one,two = -1,-1,-1
        for i in range(0,len(nums)):
            two += 1
            if nums[i] == 0:
                zero += 1
                one += 1
                self.swap(nums,zero,one)
                if one != two :
                    self.swap(nums,zero,two)
            else :
                if nums[i] == 1:
                    one += 1
                    self.swap(nums,one,two)
        return 
                                
    def swap(self,nums,i,j):
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
                
