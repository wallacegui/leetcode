class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if s is None or t is None or t=='' :
            return ''
        markT = [0]*255
        for c in t:
            markT[ord(c)] += 1
        start = 0
        min_len = len(s)
        pre_begin,pre_end = 0,len(s)-1
        markS = [0]*255
        found = 0
        res = False
        for i in range(0,len(s)):
            c = s[i]
            markS[ord(c)] += 1
            if markS[ord(c)] <= markT[ord(c)]:
                found += 1
            if found == len(t):
                res = True
                while markS[ord(s[start])] > markT[ord(s[start])] and start < i:
                    markS[ord(s[start])] -= 1
                    start += 1
                if min_len > i-start+1:
                    pre_begin = start
                    pre_end = i
                    min_len = i-start+1
                    
                markS[ord(s[start])] -= 1
                start += 1
                found -= 1
        if res:        
            return s[pre_begin:pre_begin+min_len]
        else:
            return ""
