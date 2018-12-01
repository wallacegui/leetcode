class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        word_set = set(wordDict)
        if s is None or s=='' or s in word_set:
            return True
        n = len(s)
        mark = [[0]*n for i in range(0,n)]
        for lens in range(0,n):
            for i in range(0,n-lens):
                if s[i:i+lens+1] in wordDict:
                    mark[i][i+lens] = 1
                else:
                    for k in range(i+1,i+lens+1):
                        if mark[i][k-1] and mark[k][i+lens]:
                            mark[i][i+lens] = 1
                            break
        # print('\n'.join(map(str,mark)))
        return mark[0][n-1]==1
