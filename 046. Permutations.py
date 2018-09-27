import  copy
class Solution(object):
    def permute(self, nums):
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
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                self.permuteImp(nums,i+1,res)
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
