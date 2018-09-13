class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums is None or len(nums)==0:
            return [-1,-1]
        start,end = 0,len(nums)-1
        while start <= end :
            mid = (start+end)/2
            if nums[mid] == target:
                return self.search_first_end(nums,start,mid,end,target)
            if nums[mid] > target:
                end = mid -1
            else :
                start = mid + 1
        return [-1,-1]
    
    def search_first_end(self,nums,start,index,end,target):
        first,last = index,index
        e1,s2 = index-1,index+1
        while start<=e1:
            mid = (start+e1)/2
            if nums[mid] == target:
                first = mid
                e1 = mid - 1
            else :
                start = mid +1
        while s2<=end:
            mid = (s2+end)/2
            if nums[mid] ==target:
                last = mid
                s2= mid + 1
            else :
                end = mid -1
        return [first,last]


nums = [5,7,7,8,8,10]
target = 8
print(Solution().searchRange(nums,target))
nums = [5,7,7,8,8,10]
target = 5
print(Solution().searchRange(nums,target))
nums = [5,7,7,8,8,10]
target = 10
print(Solution().searchRange(nums,target))

nums = [5,7,7,8,8,10]
target = 11
print(Solution().searchRange(nums,target))

nums = [5,7,7,8,8,10]
target = 4
print(Solution().searchRange(nums,target))

nums = [1,1,1,1,1]
target = 1
print(Solution().searchRange(nums,target))
