class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if matrix is None or len(matrix)==0 or len(matrix[0]) == 0:
            return 0
        
        res = 0
        pre = [0]*len(matrix[0])
        for i in range(0,len(matrix)):
            crent = matrix[i]
            res = max(res,self.caculate(pre,crent))
        return res
    
    def caculate(self,pre,crent):
        for i in range(0,len(crent)):
            if crent[i]=='0':
                pre[i]=0
            else:
                pre[i] += int(crent[i])
        return self.largestRectangleArea(pre)
    
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if heights is None or len(heights)==0:
            return 0
        res = 0
        stack = []
        heights.append(0)
        for i in range(0,len(heights)):
            res = max(res,self.push(stack,i,heights))
        del heights[-1]
        return res
    
    def push(self,stack,i,nums):
        x = nums[i]
        res =0
        if len(stack)==0 or x>= nums[stack[-1]]:
            stack.append(i)
            return res
        else:
            while len(stack)>0 and nums[stack[-1]] > x:
                j = stack.pop()
                weigth = i - stack[-1] -1 if len(stack)>0 else i
                res = max(res,weigth*nums[j])
            stack.append(i)
            return res
        
        
