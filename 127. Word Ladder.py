class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if wordList is None :
            return 0
        n = len(wordList)
        word_set = set(wordList)
        if endWord not in word_set:
            return 0
        queue=[(beginWord,1)]
        while len(queue)>0:
            word,step = queue.pop(0)
            for i in range(0,len(word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    new_word = word[:i]+ c + word[i+1:]
                    if new_word==endWord:
                        return step+1
                    if new_word in word_set:
                        queue.append((new_word,step+1))
                        word_set.remove(new_word)
                # print(queue,word_set)
        return 0
