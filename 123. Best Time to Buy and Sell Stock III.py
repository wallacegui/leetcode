
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if prices is None or len(prices)<2:
        	return 0
        n = len(prices)
        mark = [[0] * 2 for i in range(0,n)]
        min_curent = prices[0]
        for i in range(1,n):
            min_curent = min(min_curent,prices[i])
            mark[i][0] = max(mark[i-1][0],prices[i]- min_curent)
        
        max_curent = prices[n-1]
        for i in range(n-2,-1,-1):
            max_curent = max(max_curent,prices[i])
            mark[i][1] = max(mark[i+1][1],max_curent - prices[i])
        
        # print('\n'.join(map(str,mark)))
        res = mark[n-1][0]
        for i in range(1,n-1):
            a = mark[i][0]
            b = mark[i+1][1] if i<n-1 else 0
            res = max(res,a+b)
        return res



class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if prices is None or len(prices)<2:
        	return 0
        n = len(prices)
        mark = [[0] * n for i in range(0,n)]
        for j in range(n-1,0,-1):
            max_cur=prices[j]
            for i in range(j-1,-1,-1):
                res = mark[i+1][j] if i+1<j else 0
                max_cur = max(max_cur,prices[i])
                mark[i][j] = max(res,max_cur-prices[i])
        # print('\n'.join(map(str,mark)))
        res = mark[0][n-1]
        for k in range(1,n-1):
            res = max(res,mark[0][k]+mark[k+1][n-1])
        return res
