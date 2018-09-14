class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 1:
            return '1'
        res_pre = self.countAndSay(n-1)
        res = ''
        pre = res_pre[0]
        num = 0
        print(res_pre)
        for c in res_pre :
            if c==pre:
                num += 1
            else :
                res += str(num) + pre
                num = 1
                pre = c
            print(res)
        res += str(num) + res_pre[-1]
        return res
        
# print(Solution().countAndSay(2))
# print(Solution().countAndSay(3))
print(Solution().countAndSay(4))
# print(Solution().countAndSay(5))
print(Solution().countAndSay(6))
