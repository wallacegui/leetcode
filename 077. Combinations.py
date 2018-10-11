import copy
class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        if k>n or k<1:
            return []
        
        res,mark = [],[]
        self.help(1,n,k,mark,res)
        return res
    
    def help(self,i,n,k,mark,res):
        if i>n+1 or len(mark)>k:
            return
        if len(mark)==k:
            res.append(copy.copy(mark))
        else :
            mark.append(i)
            self.help(i+1,n,k,mark,res)
            del mark[-1]
            self.help(i+1,n,k,mark,res)
