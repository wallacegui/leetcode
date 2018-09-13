class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if nums is None or len(nums)==0:
            return -1
        start,end = 0,len(nums)-1
        while start<end:
            mid = (start+end)/2
            if nums[mid] == target:
                return mid
            if nums[mid] > target:
                end = mid -1
            else :
                start = mid + 1
        if nums[start]<target:
            return start+1
        return start

nums=[1,3,5,6]
target = 5
print(Solution().searchInsert(nums,target))

nums=[1,3,5,6]
target = 2
print(Solution().searchInsert(nums,target))

nums=[1,3,5,6]
target = 7
print(Solution().searchInsert(nums,target))

nums=[1,3,5,6]
target = 0
print(Solution().searchInsert(nums,target))
