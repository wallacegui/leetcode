class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        a1,a2=1,2
        if n == 1:
            return a1
        if n == 2:
            return a2
        for i in range(2,n):
            a3 = a1 + a2
            a1=a2
            a2 = a3
        return a3
