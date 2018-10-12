class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if board is None or word is None :
            return False
        if len(word)==0:
            return True
        m,n = len(board),len(board[0])
        mark = [[0]*n for i in range(0,m)]
        for i in range(0,m):
            for j in range(0,n):
                if board[i][j]==word[0]:
                    if self.search(i,j,0,m,n,board,word,mark):
                        return True
        return False
    
    def search(self,i,j,k,m,n,board,word,mark):
        if k==len(word):
            return True
        if i<0 or i>=m or j<0 or j>=n or board[i][j]!=word[k] or mark[i][j]==1:
            return False
        else:
            mark[i][j]=1
            if self.search(i,j-1,k+1,m,n,board,word,mark) or self.search(i,j+1,k+1,m,n,board,word,mark) or self.search(i-1,j,k+1,m,n,board,word,mark) or self.search(i+1,j,k+1,m,n,board,word,mark):
                return True
            mark[i][j]=0
            return False
            
