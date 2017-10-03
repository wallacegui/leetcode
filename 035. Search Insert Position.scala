/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
object Solution {
     def binSearch(nums: Array[Int], start:Int,end:Int,target: Int): Int = {
        if(start>=end) return start;
        var mid = (start+end)/2;
        if(nums(mid) == target) return mid;
        if(nums(mid)>target) return binSearch(nums,start,mid-1,target);
        return binSearch(nums,mid+1,end,target);
    }

    def searchInsert(nums: Array[Int], target: Int): Int = {
        if(nums==null || nums.length==0) return 0;
        var index = binSearch(nums,0,nums.length-1,target);
        if(nums(index)>=target) index
        else (index+1);
    }
}
