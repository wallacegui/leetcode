class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        res = ''
        while n > 0:
            d,m = divmod(n, 26)
            if m==0:
                d-=1
                res = 'Z'+res
            else:
                res =  chr(m-1+ord('A')) + res 
            n=d
        return res
