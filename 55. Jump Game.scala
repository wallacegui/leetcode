/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
object Solution {
    def canJump(nums: Array[Int]): Boolean = {
        var n = nums.length;
        var mark = new Array[Int](n);
        var i = n-2;
        while(i>=0){
            mark(i) = Int.MaxValue;
            var end = math.min(i+nums(i),n-1)
            for(j<- i+1 to end){
                if(j==(n-1) || (nums(j)!=0 && mark(j)!=Int.MaxValue)){
                    mark(i) = math.min(1+mark(j),mark(i))
                }
            }
            i -= 1;
        }
        return mark(0)!=Int.MaxValue;
    }
}
