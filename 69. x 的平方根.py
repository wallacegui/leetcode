class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        x0 = 0
        x1= 1
        while abs(x1-x0)> 1e-6:
            x0 = x1
            x1 = (x0+x*1.0/x0)/2
        return int(x1)
        
