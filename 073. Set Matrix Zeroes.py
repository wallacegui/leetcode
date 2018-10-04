class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if matrix is None or len(matrix)==0:
            return
        m,n=len(matrix),len(matrix[0])
        row0 = 1
        
        for j in range(0,n):
            if matrix[0][j]==0:
                row0 = 0
        
        for i in range(1,m):
            for j in range(0,n):
                if matrix[i][j]==0:
                    matrix[i][0]=0
                    matrix[0][j]=0
        

                    
        for i in range(1,m):
            if matrix[i][0]==0:
                for j in range(0,n):
                    matrix[i][j] = 0
        
        for j in range(0,n):
            if matrix[0][j]==0:
                for i in range(0,m):
                    matrix[i][j] = 0
        
        if row0 ==0:
            for j in range(0,n):
                matrix[0][j] = 0
