class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 1:
            return 0
        mark = [0]*(n+1)
        mark[0]=1
        mark[1]=1
        for i in range(2,n+1):
            for k in range(1,i+1):
                l = mark[k-1]
                r = mark[i-k]
                mark[i] += l*r
        return mark[n]
        
