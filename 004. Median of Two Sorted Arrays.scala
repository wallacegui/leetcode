/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/

def findK(arrayA:Array[Int],startA:Int,arrayB:Array[Int],startB:Int,K:Int) :Int = {
    if(arrayA.length-startA>arrayB.length-startB){
       return findK(arrayB,startB,arrayA,startA,K);
    }else{
        if(startA == arrayA.length) return arrayB(startB+K-1);
        if(K==1) return math.min(arrayA(startA),arrayB(startB));
        val p1 = math.min(arrayA.length-1,startA+K/2-1);
        val p2 = math.min(arrayB.length-1,startB+K/2-p1+startA-1)
        if(arrayA(p1)<arrayB(p2)) return findK(arrayA,p1+1,arrayB,startB,K-p1+startA-1);
        return findK(arrayA,startA,arrayB,p2+1,K-p2+startB-1);
    }
}

def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val N = nums1.length+nums2.length;
    if(N%2==1){
        return 1.0 * findK(nums1,0,nums2,0,N/2+1);
    }else{
        return (findK(nums1,0,nums2,0,N/2)+findK(nums1,0,nums2,0,N/2+1))/2.0;
    }
}
