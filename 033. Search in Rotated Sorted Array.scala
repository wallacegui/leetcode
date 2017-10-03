/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

object Solution {
        def binSearch(nums: Array[Int], start:Int,end:Int,target: Int): Int = {
        if(start>end) return -1;
        var mid = (start+end)/2;
        if(nums(mid)==target) return mid;
        if(nums(mid)>target) return binSearch(nums,start,mid-1,target);
        else return binSearch(nums,mid+1,end,target);
    }

    def searchImp(nums: Array[Int], start:Int,end:Int,target: Int):Int = {
        if(start>end) return -1;
        if(nums(start)<=nums(end)) return binSearch(nums,start,end,target);
        var mid = (start+end)/2;
        if(nums(mid)==target) return mid;
        if(nums(mid)>=nums(start)){
            if(target>=nums(start) && target< nums(mid)) return binSearch(nums,start,mid-1,target);
            if(target>nums(mid) || target <= nums(end)) return searchImp(nums,mid+1,end,target);
            return -1;
        }else{
            if(target>nums(mid) && target <=nums(end)) return binSearch(nums,mid+1,end,target);
            if(target<nums(mid) || target>=nums(start)) return searchImp(nums,start,mid-1,target);
            return -1;
        }
    }

    def search(nums: Array[Int], target: Int): Int = {
        if(nums==null || nums.length==0) return -1;
        return searchImp(nums,0,nums.length-1,target);
    }
}
