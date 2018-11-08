class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        res,pre,hold = 0,sys.maxint,sys.maxint
        if prices is None or len(prices)==1:
            return res
        for price in prices:
            if price < pre:
                res += pre-hold
                hold = price
                pre = price
            else :
                pre = price
        res += pre - hold
        return res
