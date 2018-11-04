class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        if s is None or t is None or len(s)==0 or len(t)==0 or len(s)<len(t):
            return 0
        m,n=len(s),len(t)
        st=[[0]*n for x in range(0,m)]
        st[0][0] = 1 if s[0]==t[0] else 0
        for i in range(1,m):
            if s[i]==t[0]:
                st[i][0] = st[i-1][0] + 1
            else:
                st[i][0] = st[i-1][0]
        for i in range(1,m):
            for j in range(1,min(i+1,n)):
                if s[i]==t[j]:
                    st[i][j]=st[i-1][j-1]+st[i-1][j]
                else :
                    st[i][j] = st[i-1][j]
        # print('\n'.join(map(str,st)))
        return st[m-1][n-1]
                                                        
