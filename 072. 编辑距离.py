import sys

class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        if word1 is None :
            return len(word2)
        if word2 is None :
            return len(word2)
        m,n = len(word1),len(word2)
        dp = [[0]*(n+1) for i in range(0,m+1)]
        for i in range(0,m+1):
            dp[i][0] = i
        for j in range(0,n+1):
            dp[0][j] = j
        res = sys.maxint
        for i in range(1,m+1):
            for j in range(1,n+1):
                x = 0 if word1[i-1]==word2[j-1] else 1
                y = min(dp[i-1][j],dp[i][j-1]) + 1
                dp[i][j] = min(dp[i-1][j-1]+x,y)
        return dp[m][n]
