/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
object Solution {
    def threeSumClosest(nums: Array[Int], target: Int): Int = {
        var sumsSorted = nums.sortWith(_<_);
        var minDiff = Integer.MAX_VALUE;
        var result=0;
        var count=0
        for(i <- 0 to nums.length-3){
            var start = i+1;
            var end = nums.length - 1;
            while(start<end){
                var diff = sumsSorted(start)+sumsSorted(end)+sumsSorted(i) - target;
                if(diff == 0) {
                    return target;
                }else{
                    if(diff > 0) {
                        end -= 1;
                    }else{
                        start += 1;
                    }
                    if(minDiff > math.abs(diff)){
                        minDiff = math.abs(diff);
                        result = target + diff;
                    }
                }
            }
        }
        return result;
    }
}

var nums = Array(-1,2,1,-4)

Solution.threeSumClosest(nums,1)
