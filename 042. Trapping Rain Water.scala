/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


*/
def trap(height: Array[Int]): Int = {
    var result =0;
    var pre =0;
    var start = 0;
    var end = height.length -1;
    while(start< end){
        val startVal = height(start);
        val endVal = height(end);
        pre = math.max(pre,math.min(startVal,endVal));
        if(startVal<=endVal){
            if(pre>startVal){
                result += (pre - startVal);
            }
            start += 1;
        }else{
            if(pre>endVal){
                result += (pre - endVal);
            }
            end -= 1;
        }
    }
    return result;
}

trap(Array(0,1,0,2,1,0,1,3,2,1,2,1))
