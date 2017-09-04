
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.


object Solution {
    def maxArea(height: Array[Int]): Int = {
        if(height == null || height.length<1) 
            return 0;
        var start = 0;
        var end = height.length -1;
        var area=0;
        while(start<end){
            if(height(start)<height(end)){
                area = math.max(height(start)*(end-start),area);
                start += 1;
            }else{
                area = math.max(height(end)*(end-start),area);
                end -= 1;
            }
        }
        area;
    }
}
