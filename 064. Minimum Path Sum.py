class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m,n = len(grid),len(grid[0])
        matrix = [[0]*n for i in range(0,m)]
        matrix[0][0] = grid[0][0]
        
        for i in range(1,m):
            matrix[i][0] = matrix[i-1][0] + grid[i][0]
        for j in range(1,n):
            matrix[0][j] = matrix[0][j-1] + grid[0][j]
            
        for i in range(1,m):
            for j in range(1,n):
                matrix[i][j] = grid[i][j] + min(matrix[i-1][j],matrix[i][j-1])
        return matrix[m-1][n-1]
