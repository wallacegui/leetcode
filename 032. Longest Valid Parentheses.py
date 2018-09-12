class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0
        pre = -1
        stack = []
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                if len(stack)!=0 :
                    del stack[-1]
                    if len(stack)>0 :
                        res = max(res,i-stack[-1])
                    else :
                        res = max(res,i-pre)
                else:
                    pre = i 
        return res
