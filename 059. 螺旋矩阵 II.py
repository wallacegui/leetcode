class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        res = [range(0,n) for i in range(0,n)]
        c = 0
        for i in range(0,n/2+n%2):
            for j in range(i,n-i):
                c += 1
                res[i][j] = c
                
            for j in range(i+1,n-i):
                c += 1
                res[j][n-1-i] = c
                
            for j in range(n-i-2,i-1,-1):
                c += 1
                res[n-1-i][j] = c
                
            for j in range(n-2-i,i,-1):
                c+=1
                res[j][i] = c
        return res
