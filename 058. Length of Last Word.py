class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s is None or len(s)==0:
            return 0
        splitd = filter(self.is_not_empty,s.split(" "))
        if len(splitd)==0 :
             return 0
        last = splitd[-1]
        return len(last)
    
    def is_not_empty(self,s):
        return s and len(s.strip()) > 0
