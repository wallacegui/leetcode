class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if nums is None or len(nums)==0:
            return -1
        return self.search_imp(nums,0,len(nums)-1,target)
    
    def search_imp(self,nums,start,end,target):
        if start > end :
            return -1
        if nums[start]<nums[end]:
            return self.bin_search(nums,start,end,target)
        mid = (start + end)/2
        if nums[mid]==target:
            return mid
        if nums[mid]>=nums[start]:
            if target < nums[mid] and target >= nums[start]:
                return self.bin_search(nums,start,mid-1,target)
            else :
                return self.search_imp(nums,mid+1,end,target)
        else:
            if target>nums[mid] and target <= nums[end]:
                return self.bin_search(nums,mid+1,end,target)
            else:
                return self.search_imp(nums,start,mid-1,target)
        
    def bin_search(self,nums,start,end,target):
        if start > end:
            return -1
        mid = (start+end)/2
        if nums[mid]==target:
            return mid
        if nums[mid]>target:
            return self.bin_search(nums,start,mid-1,target)
        return self.bin_search(nums,mid+1,end,target)

nums = [4,5,6,7,0,1,2]
target = 4
print(Solution().search(nums,target))
target = 3
print(Solution().search(nums,target))
nums = [3,1]
print(Solution().search(nums,1))
print(Solution().search(nums,3))
