class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        res = []
        if numRows <=0:
            return res
        res.append([1])
        for i in range(1,numRows):
            pre = res[-1]
            mark = [1]
            for j in range(1,i):
                mark.append(pre[j]+pre[j-1])
            mark.append(1)
            res.append(mark)
        return res
