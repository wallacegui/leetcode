import copy

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if target <=0 or candidates is None or len(candidates)==0:
            return List()
        candidates = list(set(candidates))
        res = []
        self.combinationSumImp(candidates,target,0,[],res)        
        return res
        
    def combinationSumImp(self, candidates, target,index,stack,res):
        if target == 0 :
            
            res += [copy.copy(stack)]
            return 
        
        if target>0 and index < len(candidates):
            for i in range(index,len(candidates)):
                stack += [candidates[i]]
                self.combinationSumImp(candidates, target-candidates[i],i,stack,res)
                del stack[-1]
