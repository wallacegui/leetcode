class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if board is None or len(board)==0 or len(board[0])==0:
            return 
        m,n = len(board),len(board[0])
        mark = [[0]*n for i in range(0,m)]
        for j in range(0,n):
            self.search(board,mark,0,j)
            self.search(board,mark,m-1,j)
        
        for i in range(1,m-1):
            self.search(board,mark,i,0)
            self.search(board,mark,i,n-1)
            
        for i in range(0,m-1):
            for j in range(0,n-1):
                if board[i][j]=='O' and mark[i][j]==0:
                    board[i][j]='X'

                
    def search(self,board,mark,i,j):
        m,n = len(board),len(board[0])
        if i<m and i>=0 and j<n and j>=0 and board[i][j]=='O' and mark[i][j]==0:
            mark[i][j]=1
            self.search(board,mark,i-1,j)
            self.search(board,mark,i+1,j)
            self.search(board,mark,i,j-1)
            self.search(board,mark,i,j+1)
