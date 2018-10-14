class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None:
            return 0
        if len(nums)<=2:
            return len(nums)
        minus = 0
        pre = nums[0]
        same = 1
        for i in range(1,len(nums)):
            if nums[i]==pre :
                same += 1
                if same>2:
                    minus += 1
                else:
                    nums[i-minus]=nums[i]
            else:
                same = 1
                pre = nums[i]
                nums[i-minus] = nums[i]
                
        return len(nums)-minus
