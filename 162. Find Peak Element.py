class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums)==0:
            return -1
        start,end = 0,len(nums)-1
        while start<end:
            if start+1==end:
                if nums[start]>nums[end]:
                    return start
                else :
                    return end
            mid = (start+end)/2
            if nums[mid]<nums[mid-1]:
                end = mid-1
            else:
                if nums[mid]<nums[mid+1]:
                    start = mid + 1
                else :
                    return mid
        return start
