class Solution(object):
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
