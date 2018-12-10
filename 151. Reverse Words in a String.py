class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return s
        s = s.strip()
        mark = s.split()
        mark.reverse()
        return ' '.join(mark)
