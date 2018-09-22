class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if height is None or len(height)<3:
            return 0
        res,max_left,max_right,i,j=0,height[0],height[len(height)-1],0,len(height)-1
        while i <= j:
            max_left = max(height[i],max_left)
            max_right = max(height[j],max_right) 
            min_mark = min(max_left,max_right)
            if height[i]>height[j]:
                res += min_mark - height[j]
                j -= 1
            else:
                res += min_mark - height[i]
                i += 1
        return res
