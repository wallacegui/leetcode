/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

Seen this question in a real interview before?   Yes  
*/

object Solution {
def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    if(nums1==null || nums2==null || n==0) return;
    var nums1End = m-1;
    var nums2End = n-1;
    for(i<- (0 to m+n-1).reverse){
        if(nums1End<0){
            nums1(i) = nums2(nums2End);
            nums2End -= 1;
        }else if(nums2End<0){
            nums1(i) = nums1(nums1End);
            nums1End -= 1;
        }else{
            if(nums1(nums1End)>nums2(nums2End)){
                nums1(i) = nums1(nums1End);
                nums1End -= 1;
            }else{
                nums1(i) = nums2(nums2End);
                nums2End -= 1;
            }
        }
    }
}
}
