class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        zhishu = [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103]
        res = {}
        for w in strs:
            self.update_dict(w,zhishu,res)
        return res.values()
        
    def update_dict(self,word,zhishu,res):
        key = 1
        for c in word:
            i = ord(c)-97
            key *= zhishu[i]
        v = res.get(key,[])
        v.append(word)
        res[key]=v
        
