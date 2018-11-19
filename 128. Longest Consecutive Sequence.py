class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return 0
        nums_set = set(nums)
        res = 0
        while len(nums_set)>0:
            num = nums_set.pop()
            begin_num,end_num=num,num
            while (end_num+1) in nums_set:
                end_num += 1
                nums_set.remove(end_num)
            while (begin_num-1) in nums_set:
                begin_num -= 1
                nums_set.remove(begin_num)
            res = max(res,end_num-begin_num+1)
        return res
