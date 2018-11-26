class Solution(object):
    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        if self.is_palindrome(s):
            return 0
        n=len(s)
        mark = [sys.maxint for i in range(0, n)]
        mark[0] = 0
        for j in range(1,n):
            # print(mark)
            if self.is_palindrome(s[0:j+1]):
                mark[j]=0
            else:
                for k in range(j,0,-1):
                    # print(k,s[k:j+1])
                    if self.is_palindrome(s[k:j+1]):
                        mark[j] = min(mark[j],1+mark[k-1])
            # print(mark)
        # print(mark)
        return mark[n-1]
                        
    def is_palindrome(self,s):
        if s is None or len(s)<=1:
            return True
        i,j=0,len(s)-1
        while i<j:
            if s[i]!=s[j]:
                return False
            i+=1
            j-=1
        return True
