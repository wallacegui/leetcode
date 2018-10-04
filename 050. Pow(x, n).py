class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n<0:
            return 1.0/self.myPow(x,(-1)*n)
        if n ==0 :
            return 1
        if n == 1:
            return x
        
        res = self.myPow(x,n/2)
        res *= res
        if n%2==1:
            res *= x
        return res
