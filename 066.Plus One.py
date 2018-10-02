class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        if digits is None or len(digits)==0 :
             return '1'
            
        jingwei = 1
        i = len(digits)-1
        while jingwei > 0 and i >=0:
            digits[i] += jingwei
            jingwei = 0
            if digits[i] >= 10:
                digits[i] -= 10
                jingwei = 1
            i -= 1                    

        if jingwei == 1:
           digits = [1] + digits
        return digits
