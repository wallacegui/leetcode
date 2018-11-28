class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        if gas is None or cost is None or len(gas)==0 or len(gas)==0 or len(gas)!=len(cost):
            return -1
        n = len(gas)
        start,res,idx = 0,gas[0]-cost[0],1
        while idx!=start and idx<n:
            print(start,idx,res)
            if res>=0:
                res += gas[idx]-cost[idx]
                idx += 1
                idx %= n
            else :
                if idx < start:
                    return -1
                start = idx
                if start==0:
                    return -1
                res = gas[idx]-cost[idx]
                idx += 1
                idx %=n
        if res>=0 :
            return start
        return -1
    
