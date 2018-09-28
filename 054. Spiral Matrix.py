class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        res = list()
        if matrix is None or len(matrix)==0:
            return res
        m,n = len(matrix),len(matrix[0])
        for i in range(0,(min(m,n)+1)/2):
            for j in range(i,n-i):
                res.append(matrix[i][j])
            for j in range(i+1,m-i):
                res.append(matrix[j][n-1-i])
            if m-1-i>i:
                for j in range(n-i-2,i-1,-1):
                    res.append(matrix[m-1-i][j])
            if n-1-i > i:
                for j in range(m-2-i,i,-1):
                    res.append(matrix[j][i])
        return res
                                                                        
