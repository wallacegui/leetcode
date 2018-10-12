class Solution(object):
    
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res,mark = [[]],[]
        
        if nums is None or len(nums)==0:
            return res
        
        self.help(0,nums,mark,res)
        return res
    
    def help(self,i,nums,mark,res):
        if i == len(nums):
            return
        mark.append(nums[i])
        res.append(copy.copy(mark))
        self.help(i+1,nums,mark,res)
        del mark[-1]
        self.help(i+1,nums,mark,res)
