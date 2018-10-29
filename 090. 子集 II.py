class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res,mark = [[]],[]
        
        if nums is None or len(nums)==0:
            return res
        nums.sort()
        
        self.help(0,nums,mark,res)
        return res
    
    def help(self,i,nums,mark,res):
        if i == len(nums):
            return
        j = i
        value = nums[j]
        while j < len(nums) and nums[j]==value :
            mark.append(nums[j])
            j+=1
        res.append(copy.copy(mark))
        self.help(j,nums,mark,res)
        while j>i:
            del mark[-1]
            j-=1
        self.help(i+1,nums,mark,res)
