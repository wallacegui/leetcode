import  copy
class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if nums is None :
            return nums
        res = []
        self.permuteImp(nums,0,res)
        return res
    
    def permuteImp(self,nums,i,res):
        if i == len(nums)-1:
            res.append(copy.copy(nums))
        else:
            for j in range(i,len(nums)):
              if self.check(nums,i,j):
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                self.permuteImp(nums,i+1,res)
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                
    def check(self,nums,i,j):
        for k in range(i,j):
            if nums[k]==nums[j]:
                return False
        return True
