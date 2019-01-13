class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sum,res=0,nums[0]
        for i in nums:
            if sum<=0:
                sum = 1
                res = i
            else :
                if i==res:
                    sum += 1
                else :
                    sum -= 1
        sum = 0
        for i in nums:
            if i==res:
                sum += 1
        return res
