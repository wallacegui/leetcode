class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if matrix is None or len(matrix)==0 or len(matrix[0])==0:
            return False
        m= len(matrix)
        n = len(matrix[0])-1
        c = 0
        while c < m and n >= 0:
            if matrix[c][n] == target:
                return True
            if matrix[c][n] > target:
                n -=1
            else :
                c += 1
        return False
