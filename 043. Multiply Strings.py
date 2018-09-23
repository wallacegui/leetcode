class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if num1 is None or num2 is None or len(num1)==0 or len(num2)==0:
            return ''
        res = ['' for i in range(0,len(num1)+len(num2))]
        for i in range(len(num1)-1,-1,-1):
            for j in range(len(num2)-1,-1,-1):
                k = len(num1)-i-1+len(num2)-j-1
                v = int(num1[i]) * int(num2[j])
                pre_v = 0 if res[k]=='' else int(res[k])
                v += pre_v
                res[k] = str(v%10)
                if v >= 10:
                    next = v/10
                    pre_next = 0 if res[k+1]=='' else int(res[k+1])
                    next += pre_next
                    res[k+1] = str(next)
        res = ''.join(res[::-1])
        if res[0]=='0':
            res = '0'
        return res
                
        
