/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/

def largestRectangleArea(heights: Array[Int]): Int = {
    val stack = new scala.collection.mutable.Stack[Int]();
    var max = 0;
    for(i<- 0 to heights.length){
        var current = if(i<heights.length) heights(i) else 0;
        while(!stack.isEmpty && heights(stack.top)>current){
            var height = heights(stack.top)
            stack.pop();
            var length = if(stack.isEmpty) (i) else (i-1-stack.top)
            max = math.max(height*length,max);
        }
        stack.push(i);
    }        
    return max;
}

largestRectangleArea(Array(2,1,5,6,2,3))
