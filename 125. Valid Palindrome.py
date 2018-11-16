class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s is None:
            return False
        i,j=0,len(s)-1
        while i<j:
            if not self.valid(s[i]):
                i+=1
            if not self.valid(s[j]):
                j-=1
            if self.valid(s[i]) and self.valid(s[j]):
                if not self.equal(s[i],s[j]):
                    return False
                else :
                    i+=1
                    j-=1
        return True
    
    def valid(self,c):
        return  'a'<=c<='z' or 'A'<=c<='Z' or '0'<=c<='9'
    
    def equal(self,c1,c2):
        if c1==c2:
            return True
        if 'a'<=c1<='z' and 'A'<=c2<='Z' and ord(c1)==32 + ord(c2):
            return True
        if 'a'<=c2<='z' and 'A'<=c1<='Z' and ord(c2)==32 + ord(c1):
            return True
        return False
