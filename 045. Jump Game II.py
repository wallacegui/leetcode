class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if  nums is None or len(nums)<=1:
            return 0
        res = 0
        pos = 0
        while pos<=len(nums)-1:
            if pos + nums[pos]>= len(nums)-1:
                return res + 1
            i = 1
            for k in range(2,min(nums[pos]+1,len(nums)-1)):
                if k+nums[pos+k]>i+nums[pos+i]:
                    i = k
            pos += i
            res += 1
            print(i)
        return res
            
