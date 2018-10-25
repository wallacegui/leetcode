class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if s1 is None :
            return s2==s3
        if s2 is None :
            return s1==s3
        if len(s1)+len(s2)!=len(s3):
            return False
        m,n = len(s1)+1,len(s2)+1
        mark = [[0]*n for x in range(0,m)]
        mark[0][0] = 1
        for i in range(0,m):
            for j in range(0,n):
                if i>0 and s1[i-1]==s3[i+j-1] and mark[i-1][j]:
                    mark[i][j] = 1
                if j>0 and s2[j-1]==s3[i+j-1] and mark[i][j-1]:
                    mark[i][j] = 1
        return mark[m-1][n-1]==1
        
