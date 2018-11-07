class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if prices is None or len(prices)==0:
            return 0
        prices.reverse()
        max_cur=prices[0]
        res=0
        for price in prices:
            max_cur = max(max_cur,price)
            res = max(res,max_cur-price)
        return res
