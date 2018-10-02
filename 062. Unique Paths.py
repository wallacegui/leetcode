class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        matrix = [[0]*n for i in range(0,m)]
        for i in range(0,m):
            matrix[i][0]=1
        for j in range(0,n):
            matrix[0][j] = 1
        for i in range(1,m):
            for j in range(1,n):
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]
        return matrix[m-1][n-1]
