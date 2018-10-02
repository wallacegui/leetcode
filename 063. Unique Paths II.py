class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        if obstacleGrid is None or len(obstacleGrid) == 0 or len(obstacleGrid[0])==0:
            return 0
        m,n = len(obstacleGrid),len(obstacleGrid[0])
        matrix = [[0]*n for i in range(0,m)]
        blocked = False
        for i in range(0,m):
            if not blocked and obstacleGrid[i][0]==0:
                matrix[i][0]=1
            else :
                blocked = True
                matrix[i][0]=0
        
        blocked = False
        for j in range(0,n):
            if not blocked and obstacleGrid[0][j]==0:
                matrix[0][j]=1
            else :
                blocked = True
                matrix[0][j]=0
                
        for i in range(1,m):
            for j in range(1,n):
                if obstacleGrid[i][j]==0:
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]
                else :
                    matrix[i][j] = 0
        return matrix[m-1][n-1]
