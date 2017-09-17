/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.


*/
///注意28行的条件
object Solution {
    def jump(nums: Array[Int]): Int = {
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
        return mark(0)
    }
}

    val arr = Array(2,3,1,1,4)
    jump(arr)

    var arr = Array(5,9,3,2,1,0,2,3,3,1,0,0)
    jump(arr)
