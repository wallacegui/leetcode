class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        res,base = 0,1
        if s is None or len(s)==0:
            return res
        for c in s[::-1]:
            res += (ord(c)-ord('A')+1)*base
            base *= 26
        return res
