/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

object Solution {
    def binSearch(nums: Array[Int], start:Int,end:Int,target: Double): Int = {
        if(start>=end) return start;
        var mid = (start+end)/2;
        if(nums(mid)>target) return binSearch(nums,start,mid-1,target);
        else return binSearch(nums,mid+1,end,target);
    }

    def searchRange(nums: Array[Int], target: Int): Array[Int] = {
        if(nums==null || nums.length==0) return Array(-1,-1);
        var minTarget = target - 0.5;
        var maxTarget = target + 0.5;
        var first = binSearch(nums,0,nums.length-1,minTarget);
        var firstShow = -1;
        if(nums(first)==target) firstShow=first;
        else if(first<nums.length-1 && nums(first+1)==target) firstShow=first+1;
        var lastShow = -1; 
        var last = binSearch(nums,first,nums.length-1,maxTarget);
        if(nums(last)==target) lastShow=last;
        else if(last>0 && nums(last-1)==target) lastShow=last-1;

        return Array(firstShow,lastShow);
    }
}
