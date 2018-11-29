class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        if ratings is None or len(ratings)==0:
            return 0
        n = len(ratings)
        mark = [1 for i in range(0,n)]
        for i in range(1,n):
            if ratings[i]>ratings[i-1]:
                mark[i] = mark[i-1] + 1
        for i in range(n-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                mark[i] = max(mark[i+1] + 1,mark[i])
        # print(mark)
        return sum(mark)
        
