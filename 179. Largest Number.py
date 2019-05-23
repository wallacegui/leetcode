class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        if sum(nums)==0:
            return '0'
        l = map(str,nums)
        l_s = sorted(l, cmp=self.strcpm,reverse=True)
        return ''.join(l_s)

    def strcpm(self,a,b):
		return cmp(a+b,b+a)
