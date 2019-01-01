class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums)==0 : 
            return -1;
        if len(nums)==1 :
            return nums[0]
        start,end=0,len(nums)-1
        while start<end:
            mid = (start+end)/2
            if nums[mid]>nums[start]:
                if nums[mid]<nums[end]:
                    end = mid-1
                else:
                    start = mid+1
            else:
                if nums[mid]>nums[end]:
                    start = mid+1
                else:
                    end = mid
        return nums[start]


s =  Solution()        
nums=[3,4,5,1,2]
print(s.findMin(nums))

nums=[4,5,6,7,0,1,2]
print(s.findMin(nums))
