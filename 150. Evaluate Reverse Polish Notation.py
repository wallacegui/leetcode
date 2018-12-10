class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        if not tokens:
            return 0
        res=[]
        for token in tokens:
            if token!='+' and token!='-' and token!='*' and token!='/' :
                res.append(int(token))
            else:
                a = res.pop()
                b = res.pop()
                if token=='+':
                    res.append(a+b)
                if token=='-':
                    res.append(b-a)
                if token=='*':
                    res.append(a*b)
                if token=='/':
                    res.append((abs(b)/abs(a))*self.sign(a)*self.sign(b))
            # print(res)
        return res[0]
    
    def sign(self,a):
        if a>0:
            return 1
        if a<0:
            return -1
        return 0
