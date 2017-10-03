/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

object Solution {
   def maxSubArray(nums: Array[Int]): Int = {
        var pre = 0 ;
        var max = Int.MinValue ;
        for(num <- nums){
            if(pre>0) {
                max = math.max(max,pre+num);
                pre = pre + num;
            }else{
                max = math.max(max,num);
                pre = math.max(0,num);
            }
        }
        max   
    }
}
