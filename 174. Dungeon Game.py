class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        if dungeon is None or len(dungeon)==0:
            return 0
        m,n = len(dungeon),len(dungeon[0])
        dungeon[m-1][n-1] = min(0,dungeon[m-1][n-1])
        for i in range(n-2,-1,-1):
            dungeon[m-1][i] += min(0,dungeon[m-1][i+1])
        for i in range(m-2,-1,-1):
            dungeon[i][n-1] += min(0,dungeon[i+1][n-1])
            
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dungeon[i][j] += min(0,max(dungeon[i+1][j],dungeon[i][j+1]))
        # print '\n'.join(map(str,dungeon))
        return max(1,1-dungeon[0][0])
