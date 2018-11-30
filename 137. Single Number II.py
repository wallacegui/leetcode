class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums)==0:
            return 0
        mark = [0 for i in range(0,33)]
        for num in nums:
            s = bin(num)
            i,n = len(s) - 1,len(s) - 1
            while s[i]!='b':
                j = n - i +1
                mark[j] += int(s[i])
                i -= 1
            if s[0] == '-':
                mark[0] += 1
        res = 0 
        for i in range(1,len(mark)):
            if mark[i]%3!=0:
                res += pow(2,i-1)
        if mark[0]%3!=0:
            res *= -1
        return res
        
