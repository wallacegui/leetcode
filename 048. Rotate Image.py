class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if matrix is None or len(matrix)<2:
            return
        n = len(matrix)
        for i in range(0,n):
            for j in range(0,n-1-i):
                self.exchange(matrix,i,j,n-1-j,n-1-i)
        for i in range(0,n/2):
            for j in range(0,n):
                self.exchange(matrix,i,j,n-1-i,j)
        
    def exchange(self,matrix,i,j,m,n):
        temp = matrix[i][j]
        matrix[i][j]=matrix[m][n]
        matrix[m][n] = temp
