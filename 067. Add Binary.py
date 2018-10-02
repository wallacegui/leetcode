class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        jingwei = 0
        i,j = len(a)-1,len(b)-1
        res = ''
        while i >=0 or j>=0 or jingwei>0:
            a_i = int(a[i]) if i >=0 else 0
            b_j = int(b[j]) if j >=0 else 0
            c = a_i + b_j + jingwei
            if c>1:
                c = c%2
                res = str(c) + res
                jingwei = 1
            else :
                jingwei = 0
                res = str(c) + res
            i -= 1
            j -= 1
        return res
