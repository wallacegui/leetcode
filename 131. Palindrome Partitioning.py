import copy

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        res,stack = [],[]
        if s is None or len(s)==0:
            return res
        self.imp(s,stack,res)
        return res
    
    def imp(self,s,stack,res):
        # print(s,stack,res)
        if len(s)==0 :
            res.append(copy.copy(stack))
        for i in range(1,len(s)+1):
            if self.is_palindrome(s[0:i]):
                stack.append(s[0:i])
                self.imp(s[i:],stack,res)
                stack.pop()
                
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
