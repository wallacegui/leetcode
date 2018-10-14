class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        if nums is None :
            return False
        return self.search_imp(0,len(nums)-1,nums,target)
    
    def search_imp(self,start,end,nums,target):
        if end< start :
            return False
        mid = start + (end-start)/2
        if nums[mid]==target:
            return True
        
        if nums[mid] < nums[end]:
            if nums[mid]< target:
                if target <= nums[end]:
                    return self.search_imp(mid+1,end,nums,target)
                else:
                    return self.search_imp(start,mid-1,nums,target)
            else:
                return self.search_imp(start,mid-1,nums,target)
        if nums[mid] > nums[end]:
            if nums[mid] > target:
                if target >= nums[start]:
                    return self.search_imp(start,mid-1,nums,target)
                else:
                    return self.search_imp(mid+1,end,nums,target)
            else:
                return self.search_imp(mid+1,end,nums,target)
        if nums[mid] == nums[end]:
            return self.search_imp(mid+1,end,nums,target) or self.search_imp(start,mid-1,nums,target)
        
