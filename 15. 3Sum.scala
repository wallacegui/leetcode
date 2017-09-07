/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
object Solution {
    def threeSum(nums: Array[Int]): List[List[Int]] = {
        var sumsSorted = nums.sortWith(_<_);
        var result:List[List[Int]] = List();
        var count=0
        for(i<- 0 to nums.length-3){
            var start = i+1;
            var end = nums.length - 1;
            while(start<end){
                var sums = sumsSorted(start)+sumsSorted(end)+sumsSorted(i);
                if(sums > 0) {
                	end -=1;
                }
                if(sums <0) {
                 start += 1；
                }
                if(sums == 0) {
            		println("i: "+i+" start: "+start+" end: "+end)
                	result = List(sumsSorted(i),sumsSorted(start),sumsSorted(end)) :: result;
                    start +=1;
                    while(start<end && sumsSorted(start)==sumsSorted(start-1)){
                    	start += 1;
                    }
                }
            }
        }
        }
        return result;
    }
}

var nums = Array(-1, 0, 1, 2, -1, -4)

Solution.threeSum(nums)
